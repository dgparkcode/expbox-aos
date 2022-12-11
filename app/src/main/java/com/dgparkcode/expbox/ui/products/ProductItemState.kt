/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import com.dgparkcode.expbox.domain.model.Product

data class ProductItemState(val product: Product) {
    val name get() = product.name
    val image get() = product.image
    val expireDate get() = product.expireAt.toString()
}
