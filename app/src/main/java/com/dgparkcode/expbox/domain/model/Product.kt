package com.dgparkcode.expbox.domain.model

import java.time.LocalDate

data class Product(
    val id: Long,
    val name: String,
    val image: String,
    val expireAt: LocalDate
)
