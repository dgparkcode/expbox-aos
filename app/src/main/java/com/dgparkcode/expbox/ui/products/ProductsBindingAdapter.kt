/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dgparkcode.expbox.R

object ProductsBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(view: AppCompatImageView, image: String?) {
        view.load(image) {
            crossfade(enable = true)
            error(R.mipmap.ic_launcher)
        }
    }

    @JvmStatic
    @BindingAdapter("isVisible")
    fun bindIsVisible(view: View, isVisible: Boolean?) {
        view.isVisible = isVisible ?: false
    }

    @JvmStatic
    @BindingAdapter("productItemStates")
    fun bindProductItemStates(view: RecyclerView, states: List<ProductItemState>?) {
        val productAdapter = view.adapter as? ProductAdapter ?: ProductAdapter().also { view.adapter = it }
        productAdapter.submitList(states)
    }
}