package com.snail.wechatmoments.binding;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapters;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;


public class RecyclerViewBindings {
    private RecyclerViewBindings() {
        throw new AssertionError("No instances.");
    }

    @BindingAdapter(value = {"itemBinding", "items", "adapter", "itemIds", "viewHolder", "onItemBound"}, requireAll = false)
    public static <T> void setAdapter(RecyclerView recyclerView, OnItemBind<T> onItemBind, List<T> items,
                                      BindingRecyclerViewAdapter<T> adapter, BindingRecyclerViewAdapter.ItemIds<? super T> itemIds,
                                      BindingRecyclerViewAdapter.ViewHolderFactory viewHolderFactory, OnItemBoundHandler<T> onItemBoundHandler) {
        ItemBinding<T> itemBinding = ((onItemBind != null) && (onItemBoundHandler != null))
                ? ItemBinding.of(new OnItemBindWrapper<>(onItemBind, onItemBoundHandler))
                : ItemBinding.of(onItemBind);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        BindingRecyclerViewAdapters.setAdapter(recyclerView, itemBinding, items, adapter, itemIds, viewHolderFactory);

    }

    @BindingAdapter("linearSnapHelper")
    public static void setLinearSnapHelper(RecyclerView view, LinearSnapHelper snapHelper) {
        view.setOnFlingListener(null);
        snapHelper.attachToRecyclerView(view);
    }

    @BindingAdapter("onRecyclerScrollListener")
    public static void addOnScrollListener(RecyclerView view, RecyclerView.OnScrollListener listener) {
        if (listener != null) {
            view.addOnScrollListener(listener);
        }
    }

    @BindingAdapter(value = {"itemDecoration", "index"}, requireAll = false)
    public static void addItemDecoration(RecyclerView view, RecyclerView.ItemDecoration itemDecoration, int index) {
        if (itemDecoration != null) {
            view.addItemDecoration(itemDecoration);
        }
    }

    public interface OnItemBoundHandler<T> {
        void onItemBound(int position);
    }

    private static class OnItemBindWrapper<T> implements OnItemBind<T> {

        private final OnItemBind<T> onItemBind;
        private final OnItemBoundHandler<T> onItemBoundHandler;

        public OnItemBindWrapper(OnItemBind<T> onItemBind, OnItemBoundHandler<T> onItemBoundHandler) {
            this.onItemBind = onItemBind;
            this.onItemBoundHandler = onItemBoundHandler;
        }

        @Override
        public void onItemBind(ItemBinding itemBinding, int position, T item) {
            onItemBind.onItemBind(itemBinding, position, item);
            onItemBoundHandler.onItemBound(position);
        }

    }
}
