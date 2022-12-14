/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.dgparkcode.expbox.R

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun AppCompatImageView.bindLoadImage(image: String?) {
        this.load(image) {
            crossfade(enable = true)
            error(R.mipmap.ic_launcher)
        }
    }
}