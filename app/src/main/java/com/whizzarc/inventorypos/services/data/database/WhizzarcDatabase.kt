package com.whizzarc.inventorypos.services.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.whizzarc.inventorypos.services.data.dao.CustomerDao
import com.whizzarc.inventorypos.services.data.dao.ProductMasterDao
import com.whizzarc.inventorypos.services.data.models.Customer
import com.whizzarc.inventorypos.services.data.models.ProductMaster
import com.whizzarc.inventorypos.utils.converters.DateToLongConverter

@Database(entities = [Customer:: class,ProductMaster :: class], version = 1, exportSchema = false)
@TypeConverters(DateToLongConverter::class)
abstract class WhizzarcDatabase : RoomDatabase() {
    abstract fun getCustomerDao() : CustomerDao
    abstract fun getProductMasterDao() : ProductMasterDao
}