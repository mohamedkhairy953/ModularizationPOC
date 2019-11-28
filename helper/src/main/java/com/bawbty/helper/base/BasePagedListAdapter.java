package com.bawbty.helper.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.bawbty.helper.databinding.NetworkItemBinding;

public abstract class BasePagedListAdapter<T> extends PagedListAdapter<T, PagedListBindingViewHolder<T>> {

    private static final int TYPE_PROGRESS = 0;
    private NetworkState networkState;

    protected BasePagedListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PagedListBindingViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_PROGRESS) {
            NetworkItemBinding headerBinding = NetworkItemBinding.inflate(layoutInflater, parent, false);
            NetworkStateItemViewHolder viewHolder =
                    new NetworkStateItemViewHolder(headerBinding);
            return viewHolder;
        } else {
            ViewDataBinding itemBinding =
                    DataBindingUtil.inflate(layoutInflater, getLayoutIdForPosition(), parent, false);
            return new PagedListBindingViewHolder<>(itemBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PagedListBindingViewHolder<T> holder, int position) {
        if (holder.tag == 1) {
            holder.bind(getItem(position));
            holder.bind(this);
        } else {
            ((NetworkStateItemViewHolder) holder).bindView(networkState);
            holder.bind(this);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition();
    }

    public abstract int getLayoutIdForPosition();

    public void setNetworkState(NetworkState newNetworkState) {
        NetworkState previousState = this.networkState;
        boolean previousExtraRow = hasExtraRow();
        this.networkState = newNetworkState;
        boolean newExtraRow = hasExtraRow();
        if (previousExtraRow != newExtraRow) {
            if (previousExtraRow) {
                notifyItemRemoved(getItemCount());
            } else {
                notifyItemInserted(getItemCount());
            }
        } else if (newExtraRow && previousState != newNetworkState) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    public boolean hasExtraRow() {
        return networkState != null && networkState != NetworkState.LOADED;
    }

    public class NetworkStateItemViewHolder extends PagedListBindingViewHolder<T> {

        public int tag = 0;
        private NetworkItemBinding binding;

        NetworkStateItemViewHolder(NetworkItemBinding binding) {
            super(binding);
            this.binding = binding;
        }

        void bindView(NetworkState networkState) {
            if (networkState != null && networkState.getStatus() == NetworkState.Status.RUNNING) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar.setVisibility(View.GONE);
            }

            if (networkState != null && networkState.getStatus() == NetworkState.Status.FAILED) {
                binding.errorMsg.setVisibility(View.VISIBLE);
                binding.errorMsg.setText(networkState.getMsg());
            } else {
                binding.errorMsg.setVisibility(View.GONE);
            }
        }

    }

}
