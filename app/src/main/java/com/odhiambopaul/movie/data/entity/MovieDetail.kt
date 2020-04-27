package com.odhiambopaul.movie.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import com.odhiambopaul.movie.data.entity.*

data class MovieDetail(
    val adult: Boolean, // false
    val backdrop_path: String, // /sVYHWr7xeeo2MEs9SIyxg1bRzFM.jpg
    val belongs_to_collection: BelongsToCollection,
    val budget: Int, // 0
    val genres: List<Genre>,
    val homepage: String, // http://www.sonypictures.com/homevideo/residentevildegeneration
    val id: Int, // 13648
    val imdb_id: String, // tt1174954
    val original_language: String, // en
    val original_title: String, // Baiohazâdo: Dijenerêshon
    val overview: String, // A zombie attack brings chaos to Harvardville Airport. Leon Kennedy and Claire Redfield , who fought the sinister Umbrella Corporation during the Raccoon City tragedy 7 years ago, are back. In high-octane Resident Evil style, they're ready to battle a rogue warrior who is seeking revenge after his family was killed in Raccoon City. The deadly G-Virus is unleashed and a new mutated monster rampages.
    val popularity: Double, // 9.079
    val poster_path: String, // /pZ3rh5Yu7akSFKXUjKpBU9CsH39.jpg
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String, // 2008-02-13
    val revenue: Int, // 0
    val runtime: Int, // 97
    val spoken_languages: List<SpokenLanguage>,
    val status: String, // Released
    val tagline: String,
    val title: String, // Resident Evil: Degeneration
    val video: Boolean, // false
    val vote_average: Double, // 6.5
    val vote_count: Int // 479
)