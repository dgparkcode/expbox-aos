/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import android.os.Bundle
import android.view.View
import com.dgparkcode.expbox.R
import com.dgparkcode.expbox.databinding.FragmentProductsBinding
import com.dgparkcode.expbox.ui.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BindingFragment<FragmentProductsBinding>(R.layout.fragment_products) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}