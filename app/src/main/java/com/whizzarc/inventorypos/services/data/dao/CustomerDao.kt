package com.whizzarc.inventorypos.services.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.whizzarc.inventorypos.services.data.models.Customer

@Dao
interface CustomerDao {
    @Insert
    suspend fun insertCustomer(customer: Customer):Long

    @Update
    suspend fun updateCustomer(customer: Customer)

    @Query("SELECT * FROM CUSTOMER")
    suspend fun getAllCustomers(): List<Customer>

    @Query("SELECT * FROM CUSTOMER WHERE phoneNumber = :customerId")
    suspend fun getCustomerById(customerId: Int): Customer?

    @Query("DELETE FROM CUSTOMER WHERE phoneNumber = :customerId")
    suspend fun deleteCustomerById(customerId: Int)
    @Query("DELETE FROM CUSTOMER")
    suspend fun deleteAll()
}
