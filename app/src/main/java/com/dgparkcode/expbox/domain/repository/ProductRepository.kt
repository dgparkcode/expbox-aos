package com.dgparkcode.expbox.domain.repository

import com.dgparkcode.expbox.domain.model.Product

interface ProductRepository {

    suspend fun createProduct(product: Product)

    suspend fun updateProduct(product: Product)

    suspend fun deleteProduct(product: Product)

    suspend fun getProductById(productId: Long): Product?
}