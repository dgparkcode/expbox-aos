/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dgparkcode.expbox.R
import com.dgparkcode.expbox.databinding.FragmentProductsBinding
import com.dgparkcode.expbox.ui.common.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BindingFragment<FragmentProductsBinding>(R.layout.fragment_products) {

    private val productsViewModel by viewModels<ProductsViewModel>()
    private val productsNavigator by lazy { ProductsNavigator(productsViewModel, findNavController()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = productsViewModel
            navigator = productsNavigator
        }
    }
}