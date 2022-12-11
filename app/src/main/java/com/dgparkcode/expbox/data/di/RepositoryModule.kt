/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.data.di

import com.dgparkcode.expbox.data.local.dao.ProductDao
import com.dgparkcode.expbox.data.repository.ProductRepositoryImpl
import com.dgparkcode.expbox.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        @IoDispatcher dispatcher: CoroutineDispatcher,
        dao: ProductDao,
    ): ProductRepository = ProductRepositoryImpl(dispatcher, dao)
}