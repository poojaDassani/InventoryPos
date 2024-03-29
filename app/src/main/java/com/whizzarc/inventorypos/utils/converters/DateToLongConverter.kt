package com.whizzarc.inventorypos.utils.converters
import androidx.room.TypeConverter
import java.util.Date

class DateToLongConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}