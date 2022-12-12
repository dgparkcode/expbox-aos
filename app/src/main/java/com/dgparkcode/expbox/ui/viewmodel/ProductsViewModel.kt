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
import kotlin.random.Random

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

            val imageUrls = listOf(
                "https://cdn.pixabay.com/photo/2022/12/04/10/13/snow-7634083_640.jpg",
                "https://cdn.pixabay.com/photo/2022/11/20/09/58/leaves-7603946__340.jpg",
                "https://cdn.pixabay.com/photo/2022/11/19/18/45/gray-geese-7602847__340.jpg",
                "https://cdn.pixabay.com/photo/2022/12/06/06/21/lavender-7638368_640.jpg",
                "https://cdn.pixabay.com/photo/2022/12/02/18/37/middle-spotted-woodpecker-7631440_640.jpg",
                "https://cdn.pixabay.com/photo/2022/12/04/23/12/siblings-7635490__340.jpg",
            )
            val fakeItems = (0..20).map {
                val product = Product(
                    id = it.toLong(),
                    name = "product name $it",
                    image = imageUrls[Random.nextInt(imageUrls.size)],
                    expireAt = LocalDate.now()
                )
                ProductItemState(product)
            }
            _productsState.update { it.copy(isLoading = false, productItems = fakeItems) }
        }
    }
}