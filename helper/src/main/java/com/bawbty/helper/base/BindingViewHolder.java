package com.bawbty.helper.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

class BindingViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    BindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(Object obj) {
        // TODO (Uncomment) : binding.setVariable(BR.obj, obj);
    }

    void bind(BaseAdapter adapter) {
        // TODO (Uncomment) : binding.setVariable(BR.adapter, adapter);
        binding.executePendingBindings();
    }
    // TODO : uncomment when adding adapter and obj in layout
}