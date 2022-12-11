/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.dgparkcode.expbox.R
import kotlinx.coroutines.launch

object ProductsBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(view: AppCompatImageView, image: String?) {
        if (image == null) {
            view.setImageResource(R.mipmap.ic_launcher)
            return
        }

        view.load(image) {
            crossfade(enable = true)
            placeholder(R.mipmap.ic_launcher)
            transformations(CircleCropTransformation())
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
        view.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
            val productAdapter = view.adapter as? ProductAdapter ?: ProductAdapter().also { view.adapter = it }
            productAdapter.submitList(states)
        }
    }
}