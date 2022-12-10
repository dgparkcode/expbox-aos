/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.data.local.converter

import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDateTypeConverter {

    @TypeConverter
    fun localDateToDateString(localDate: LocalDate?) = localDate?.toString()

    @TypeConverter
    fun dateStringToLocalDate(dateString: String?) = dateString?.let { LocalDate.parse(it) }
}