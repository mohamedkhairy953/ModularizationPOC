package com.bawbty.helper.base;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

public abstract class BaseAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private ViewDataBinding binding;
    private Context context;

    @NonNull
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater =
                LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        BindingViewHolder viewHolder = new BindingViewHolder(binding);

        viewHolder.bind(this);

        return viewHolder;
    }

    protected ViewDataBinding getBindingClass() {
        return binding;
    }

    public Context getContext() {
        return context;
    }

    public void onBindViewHolder(@NotNull BindingViewHolder holder,
                                 int position) {
        Object obj = getObjForPosition(position);
        holder.bind(obj);
        Log.i("BaseAdapter", "onBindViewHolder");
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    abstract Object getObjForPosition(int position);

    abstract int getLayoutIdForPosition(int position);
}