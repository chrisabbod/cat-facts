package com.chrisabbod.catfacts

import retrofit2.http.GET
import retrofit2.http.Query

interface CatFactsAPI {

    @GET("/fact")
    suspend fun retrieveRandomFact(
        @Query("max_length") length: Int
    ): Data

    @GET("/facts")
    suspend fun retrieveListOfFacts(
        @Query("max_length") length: Int,
        @Query("limit") limit: Int
    ): CatFactResponse
}