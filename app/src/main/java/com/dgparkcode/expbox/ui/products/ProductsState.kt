/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

data class ProductsState(
    val isLoading: Boolean = false,
    val productItems: List<ProductItemState> = emptyList(),
    val errorMessage: String? = null,
)
