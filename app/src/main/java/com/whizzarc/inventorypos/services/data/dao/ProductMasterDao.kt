package com.whizzarc.inventorypos.services.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.whizzarc.inventorypos.services.data.models.ProductMaster

@Dao
interface ProductMasterDao {
    @Insert
    suspend fun insertProduct(product: ProductMaster)

    @Update
    suspend fun updateProduct(product: ProductMaster)

    @Query("SELECT * FROM ProductMaster")
    suspend fun getAllProducts(): List<ProductMaster>

    @Query("SELECT * FROM ProductMaster WHERE barcode = :barcode")
    suspend fun getProductByBarcode(barcode: Int): ProductMaster?

    @Query("DELETE FROM ProductMaster WHERE barcode = :barcode")
    suspend fun deleteProductByBarcode(barcode: Int)
}