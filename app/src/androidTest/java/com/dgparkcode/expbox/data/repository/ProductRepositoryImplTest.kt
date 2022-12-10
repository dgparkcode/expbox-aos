/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.data.repository

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.dgparkcode.expbox.data.local.AppDatabase
import com.dgparkcode.expbox.data.local.dao.ProductDao
import com.dgparkcode.expbox.domain.model.Product
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

@OptIn(ExperimentalCoroutinesApi::class)
class ProductRepositoryImplTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: ProductDao
    private lateinit var product: Product

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java).build()
        dao = db.productDao
        product = Product(id = 1, name = "test product", image = "", expireAt = LocalDate.now())
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun getProductByIdTest() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val repository = ProductRepositoryImpl(testDispatcher, dao)

        // empty
        var savedProduct = repository.getProductById(product.id)
        assertThat(savedProduct).isNull()

        // create and get
        repository.createProduct(product)
        savedProduct = repository.getProductById(product.id)
        assertThat(savedProduct).isNotNull()
        assertThat(savedProduct).isEqualTo(product)
    }

    @Test
    fun updateProductTest() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val repository = ProductRepositoryImpl(testDispatcher, dao)

        // create
        repository.createProduct(product)
        val savedProduct = repository.getProductById(product.id)
        assertThat(savedProduct).isNotNull()

        // update
        val newName = "new name"
        repository.updateProduct(product.copy(name = newName))
        val updatedProduct = repository.getProductById(product.id)
        assertThat(updatedProduct).isNotNull()
        assertThat(updatedProduct).isNotEqualTo(savedProduct)
        assertThat(updatedProduct?.name).isEqualTo(newName)
    }

    @Test
    fun deleteProductTest() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        val repository = ProductRepositoryImpl(testDispatcher, dao)

        // create
        repository.createProduct(product)
        val savedProduct = repository.getProductById(product.id)
        assertThat(savedProduct).isNotNull()

        // delete
        repository.deleteProduct(product)
        val deletedProduct = repository.getProductById(product.id)
        assertThat(deletedProduct).isNull()
    }
}