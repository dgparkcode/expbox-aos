/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.common

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("isVisible")
    fun View.bindIsVisible(isVisible: Boolean?) {
        this.isVisible = isVisible ?: false
    }
}