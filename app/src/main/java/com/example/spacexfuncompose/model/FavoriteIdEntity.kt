package com.example.spacexfuncompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "FavoriteIdEntity")
data class FavoriteIdEntity(val favoriteRocketId: String): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}