/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dgparkcode.expbox.data.local.converter.LocalDateTypeConverter
import com.dgparkcode.expbox.data.local.dao.ProductDao
import com.dgparkcode.expbox.data.model.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1, exportSchema = true
)
@TypeConverters(LocalDateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val productDao: ProductDao
}