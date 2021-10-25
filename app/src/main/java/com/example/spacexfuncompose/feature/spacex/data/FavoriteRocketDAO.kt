package com.example.spacexfuncompose.feature.spacex.data

import androidx.room.Dao
import androidx.room.Query
import com.example.spacexfuncompose.model.FavoriteIdEntity

@Dao
interface FavoriteRocketDAO {

    @Query("SELECT * FROM FavoriteIdEntity")
    suspend fun getAllRockets(): MutableList<FavoriteIdEntity>

    @Query("INSERT INTO FavoriteIdEntity(favoriteRocketId) VALUES( :favoriteRocketId)")
    suspend fun insertRocket(favoriteRocketId: String) : Unit

    @Query("DELETE FROM FavoriteIdEntity WHERE favoriteRocketId = :favoriteRocketId")
    suspend fun deleteRocket(favoriteRocketId: String)
}
