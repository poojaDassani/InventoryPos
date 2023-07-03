package com.whizzarc.inventorypos.services.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "ProductMaster")
data class ProductMaster(
    @PrimaryKey
    val barcode: Int,
    val productName: String,
    val mrp: Float,
    val sp: Float,
    val pp: Float,
    val uom: String,
    val quantity: Float,
    val categoryId: Int,
    val brandId: Int?,
    val image: String?,
    val expiryDate: Date?,
    val mfgDate: Date?,
    val isDeleted: Boolean,
    val isDisabled: Boolean,
    val toSync: Boolean,
    val createdTime: Date,
    val updatedTime: Date,
)
