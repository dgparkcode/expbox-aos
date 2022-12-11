/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.data.repository

import com.dgparkcode.expbox.data.local.dao.ProductDao
import com.dgparkcode.expbox.data.model.toDomain
import com.dgparkcode.expbox.data.model.toEntity
import com.dgparkcode.expbox.domain.model.Product
import com.dgparkcode.expbox.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val productDao: ProductDao,
) : ProductRepository {

    override suspend fun createProduct(product: Product) = withContext(dispatcher) {
        productDao.insertProduct(product.toEntity())
    }

    override suspend fun updateProduct(product: Product) = withContext(dispatcher) {
        productDao.updateProduct(product.toEntity())
    }

    override suspend fun deleteProduct(product: Product) = withContext(dispatcher) {
        productDao.deleteProduct(product.toEntity())
    }

    override suspend fun getProductById(productId: Long): Product? = withContext(dispatcher) {
        return@withContext productDao.getProductById(productId)?.toDomain()
    }
}