package com.bawbty.helper.base;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class PagedListBindingViewHolder<T> extends RecyclerView.ViewHolder {

    int tag = 1;
    private final ViewDataBinding binding;

    public PagedListBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(T item) {
        // TODO (Uncomment) : binding.setVariable(BR.obj, item);
    }

    void bind(BasePagedListAdapter adapter) {
        // TODO (Uncomment) : binding.setVariable(BR.adapter, adapter);
        binding.executePendingBindings();
    }

    // TODO : uncomment when adding adapter and obj in layout

}
