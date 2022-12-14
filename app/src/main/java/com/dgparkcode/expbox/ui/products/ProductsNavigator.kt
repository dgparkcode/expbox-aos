/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import androidx.navigation.NavController
import com.dgparkcode.expbox.ui.common.Navigator

data class ProductsNavigator(
    private val viewModel: ProductsViewModel,
    private val navController: NavController,
) : Navigator {

    override fun navigate(destinationId: Int) {
        navController.navigate(destinationId)
        viewModel.onAction(ProductsAction.OnMovedToProductAdder)
    }
}