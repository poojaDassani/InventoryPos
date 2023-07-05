package com.whizzarc.inventorypos.customerModule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whizzarc.inventorypos.services.data.models.Customer
import com.whizzarc.inventorypos.services.data.repo.CustomerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(private val customerRepo: CustomerRepo): ViewModel() {

    private val _getCustomer = MutableLiveData<List<Customer>>()
    val getCustomer: LiveData<List<Customer>>
        get() = _getCustomer

    fun getCustomers(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = customerRepo.getAllCustomers()
                _getCustomer.postValue(products)
            } catch (e: Exception) {
                _getCustomer.postValue(ArrayList())
            }
        }
    }

    private val _insertCustomer = MutableLiveData<Customer?>()
    val insertCustomer: LiveData<Customer?>
        get() = _insertCustomer

    fun insertCustomer(customer: Customer) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val customerId = customerRepo.insertCustomer(customer)
                customer.phoneNumber= customerId
               _insertCustomer.postValue(customer)
            } catch (e: Exception) {
                _insertCustomer.postValue(null)
            }
        }
    }

    fun deleteData() {
        runBlocking{
            customerRepo.deleteAllCustomers()
        }
    }
}