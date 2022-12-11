/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgparkcode.expbox.domain.model.Product
import com.dgparkcode.expbox.domain.repository.ProductRepository
import com.dgparkcode.expbox.ui.products.ProductItemState
import com.dgparkcode.expbox.ui.products.ProductsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository,
) : ViewModel() {

    private val _productsState = MutableStateFlow(ProductsState())
    val productsState get() = _productsState.asStateFlow()

    init {
        viewModelScope.launch {
            _productsState.update { it.copy(isLoading = true) }

            delay(3000L)

            val fakeItems = (0..20).map {
                val product = Product(
                    id = it.toLong(),
                    name = "product name $it",
                    image = "",
                    expireAt = LocalDate.now()
                )
                ProductItemState(product)
            }
            _productsState.update { it.copy(isLoading = false, productItems = fakeItems) }
        }
    }
}