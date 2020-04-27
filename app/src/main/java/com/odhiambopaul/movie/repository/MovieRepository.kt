package com.odhiambopaul.movie.repository

import com.odhiambopaul.movie.data.dao.MovieDao
import javax.inject.Inject

/*
*To have Separation of Concern(SOC), I created a repository class which will handle all database related operations via DAO.
* */
class MovieRepository @Inject constructor(private val movieDao: MovieDao){
    //all database operations

}