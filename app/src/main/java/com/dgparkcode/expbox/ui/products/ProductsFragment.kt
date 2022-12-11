/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dgparkcode.expbox.R
import com.dgparkcode.expbox.databinding.FragmentProductsBinding
import com.dgparkcode.expbox.ui.BindingFragment
import com.dgparkcode.expbox.ui.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BindingFragment<FragmentProductsBinding>(R.layout.fragment_products) {

    private val productsViewModel by viewModels<ProductsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = productsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}