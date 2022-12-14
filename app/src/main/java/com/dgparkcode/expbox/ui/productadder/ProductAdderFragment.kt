/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.productadder

import android.os.Bundle
import android.view.View
import com.dgparkcode.expbox.R
import com.dgparkcode.expbox.databinding.FragmentProductAdderBinding
import com.dgparkcode.expbox.ui.common.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductAdderFragment : BindingFragment<FragmentProductAdderBinding>(R.layout.fragment_product_adder) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}