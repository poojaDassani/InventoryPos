package com.whizzarc.inventorypos.services.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseUtility {

    @Singleton
    @Provides
    fun provideSnapbizzDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        WhizzarcDatabase::class.java,
        "WhizzarcDb"
    ).build()

    @Singleton
    @Provides
    fun provideCustomerDao(db: WhizzarcDatabase) = db.getCustomerDao()

    @Singleton
    @Provides
    fun provideProductMasterDao(db: WhizzarcDatabase) = db.getProductMasterDao()
}