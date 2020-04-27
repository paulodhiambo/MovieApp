package com.odhiambopaul.movie.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "OmdbMovie")
data class OmdbMovie(
    val Actors: String, // Aaron Paul, Dominic Cooper, Imogen Poots, Kid Cudi
    val Awards: String, // 1 win & 4 nominations.
    val BoxOffice: String, // $40,138,026
    val Country: String, // USA, India
    val DVD: String, // 05 Aug 2014
    val Director: String, // Scott Waugh
    val Genre: String, // Action, Crime, Thriller
    val Language: String, // English
    val Metascore: String, // 39
    val Plot: String, // Fresh from prison, a street racer who was framed by a wealthy business associate joins a cross country race with revenge in mind. His ex-partner, learning of the plan, places a massive bounty on his head as the race begins.
    val Poster: String, // https://m.media-amazon.com/images/M/MV5BMTQ3ODY4NzYzOF5BMl5BanBnXkFtZTgwNjI3OTE4MDE@._V1_SX300.jpg
    val Production: String, // Walt Disney Studios
    val Rated: String, // PG-13
    val Ratings: List<Rating>,
    val Released: String, // 14 Mar 2014
    val Response: String, // True
    val Runtime: String, // 132 min
    val Title: String, // Need for Speed
    val Type: String, // movie
    val Website: String, // N/A
    val Writer: String, // George Gatins (screenplay), George Gatins (story), John Gatins (story)
    val Year: String, // 2014
    @PrimaryKey(autoGenerate = false)
    val imdbID: String, // tt2369135
    val imdbRating: String, // 6.5
    val imdbVotes: String // 158,878
)