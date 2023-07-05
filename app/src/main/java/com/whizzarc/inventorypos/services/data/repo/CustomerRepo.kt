package com.whizzarc.inventorypos.services.data.repo

import com.whizzarc.inventorypos.services.data.dao.CustomerDao
import com.whizzarc.inventorypos.services.data.models.Customer
import javax.inject.Inject

class CustomerRepo @Inject constructor(private val customerDao: CustomerDao) {

    suspend fun getAllCustomers() = customerDao.getAllCustomers()
    suspend fun insertCustomer(customer: Customer):Long = customerDao.insertCustomer(customer)
    suspend fun deleteAllCustomers() = customerDao.deleteAll()
}