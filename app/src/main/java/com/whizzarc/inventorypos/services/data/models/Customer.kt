package com.whizzarc.inventorypos.services.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Customer")
data class Customer(
    @PrimaryKey
    val phoneNumber: Int,
    val firstName: String,
    val lastName: String?,
    val address: String?,
    val alternateNumber: Int?,
    val gender: String?,
    val dob: Date?,
    val email: String?,
    val postalCode: Int?,
    val toSync: Boolean,
    val isDisabled: Boolean,
    val createdTime: Date,
    val updatedTime: Date,
)
