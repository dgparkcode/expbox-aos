/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.data.di

import android.content.Context
import androidx.room.Room
import com.dgparkcode.expbox.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    private const val DB_NAME = "expbox_db"

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context) = Room
        .databaseBuilder(appContext, AppDatabase::class.java, DB_NAME)
        .build()

    @Singleton
    @Provides
    fun provideProductDao(appDatabase: AppDatabase) = appDatabase.productDao
}