/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dgparkcode.expbox.domain.model.Product
import java.time.LocalDate

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val image: String,
    val expireAt: LocalDate,
)

internal fun Product.toEntity() = ProductEntity(id = id, name = name, image = image, expireAt = expireAt)

internal fun ProductEntity.toDomain() = Product(id = id, name = name, image = image, expireAt = expireAt)