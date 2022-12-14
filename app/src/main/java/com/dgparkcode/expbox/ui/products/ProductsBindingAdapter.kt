/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object ProductsBindingAdapter {

    @JvmStatic
    @BindingAdapter("productItems")
    fun RecyclerView.bindProductItems(states: List<ProductItemUiState>?) {
        val productAdapter = this.adapter as? ProductItemsAdapter ?: ProductItemsAdapter().also { this.adapter = it }
        productAdapter.submitList(states)
    }

    @JvmStatic
    @BindingAdapter("navigator", "navigateId")
    fun View.bindProductsNavigatorAndNavigateId(navigator: ProductsNavigator, navigateId: Int?) {
        if (navigateId == null) return
        navigator.navigate(navigateId)
    }
}