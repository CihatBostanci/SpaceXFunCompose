package com.example.spacexfuncompose.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.spacexfuncompose.feature.spacex.data.FavoriteRocketDAO
import com.example.spacexfuncompose.model.FavoriteIdEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Database(entities = [FavoriteIdEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteRocketDAO(): FavoriteRocketDAO

}

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideFavoriteRocketDao(appDatabase: AppDatabase): FavoriteRocketDAO {
        return appDatabase.favoriteRocketDAO()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "RssReader"
        ).build()
    }
}