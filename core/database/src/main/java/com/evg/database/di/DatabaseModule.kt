package com.evg.database.di

import android.content.Context
import androidx.room.Room
import com.evg.database.data.repository.DatabaseRepositoryImpl
import com.evg.database.data.storage.CityDatabase
import com.evg.database.domain.repository.DatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideCityDatabase(
        @ApplicationContext context: Context
    ) : CityDatabase {
        return Room.databaseBuilder(
            context,
            CityDatabase::class.java,
            CityDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDatabaseRepository(
        cityDatabase: CityDatabase,
    ): DatabaseRepository {
        return DatabaseRepositoryImpl(
            cityDatabase = cityDatabase,
        )
    }
}