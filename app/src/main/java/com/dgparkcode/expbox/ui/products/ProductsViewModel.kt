/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgparkcode.expbox.R
import com.dgparkcode.expbox.domain.model.Product
import com.dgparkcode.expbox.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject
import kotlin.random.Random

sealed class ProductsAction {
    object MoveToProductAdder : ProductsAction()
    object OnMovedToProductAdder : ProductsAction()
}

data class ProductsUiState(
    val isLoading: Boolean = false,
    val productItems: List<ProductItemUiState> = emptyList(),
    val errorMessage: String? = null,
    val destinationId: Int? = null,
)

data class ProductItemUiState(val product: Product) {
    val productName get() = product.name
    val productPhoto get() = product.image
    val productExpireDate get() = product.expireAt.toString()
}

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepository: ProductRepository,
) : ViewModel() {

    private val _productsUiState = MutableStateFlow(ProductsUiState())
    val productsUiState get() = _productsUiState.asStateFlow()

    init {
        getAllProductItems()
    }

    fun onAction(action: ProductsAction) {
        when (action) {
            is ProductsAction.MoveToProductAdder -> updateDestinationIdState(PRODUCT_ADDER_DEST_ID)
            is ProductsAction.OnMovedToProductAdder -> updateDestinationIdState(null)
        }
    }

    private fun getAllProductItems() {
        viewModelScope.launch {
            _productsUiState.update { it.copy(isLoading = true) }

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
                ProductItemUiState(product)
            }

            _productsUiState.update { it.copy(isLoading = false, productItems = fakeItems) }
        }
    }

    private fun updateDestinationIdState(destinationId: Int?) {
        viewModelScope.launch {
            _productsUiState.update { it.copy(destinationId = destinationId) }
        }
    }

    companion object {
        private const val PRODUCT_ADDER_DEST_ID = R.id.action_productsFragment_to_productAdderFragment
    }
}