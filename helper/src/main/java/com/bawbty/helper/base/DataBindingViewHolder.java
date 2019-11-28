package com.bawbty.helper.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

class DataBindingViewHolder<T> extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    DataBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(T item) {
        // TODO (Uncomment) : binding.setVariable(BR.obj, item);
    }

    void bind(BaseListAdapter adapter) {
        // TODO (Uncomment) : binding.setVariable(BR.adapter, adapter);
        binding.executePendingBindings();
    }
    // TODO : uncomment when adding adapter and obj in layout

}
