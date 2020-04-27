package com.odhiambopaul.movie.data.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Movie")
data class Movie(
    val adult: Boolean, // false
    val backdrop_path: String?, // /5BwqwxMEjeFtdknRV792Svo0K1v.jpg
    @PrimaryKey(autoGenerate = false)
    val id: Int, // 419704
    val original_language: String, // en
    val original_title: String, // Ad Astra
    val overview: String, // The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.
    val popularity: Double, // 501.294
    val poster_path: String, // /xJUILftRf6TJxloOgrilOTJfeOn.jpg
    val release_date: String, // 2019-09-17
    val title: String, // Ad Astra
    val video: Boolean, // false
    val vote_average: Double, // 6
    val vote_count: Int // 3037
)