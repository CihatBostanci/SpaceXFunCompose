package com.example.spacexfuncompose.feature.spacex.data

import androidx.room.Dao
import androidx.room.Query
import com.example.spacexfuncompose.model.FavoriteIdEntity

@Dao
interface FavoriteRocketDAO {

    @Query("SELECT * FROM FavoriteIdEntity")
    fun getAllRockets(): MutableList<FavoriteIdEntity>

    @Query("INSERT INTO FavoriteIdEntity(favoriteRocketId) VALUES( :favoriteRocketId)")
    fun insertRocket(favoriteRocketId: String)

    @Query("DELETE FROM FavoriteIdEntity WHERE favoriteRocketId = :favoriteRocketId")
    fun deleteRocket(favoriteRocketId: String)
}
