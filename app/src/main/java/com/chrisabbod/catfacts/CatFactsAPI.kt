package com.chrisabbod.catfacts

import retrofit2.http.GET

interface CatFactsAPI {

    @GET("/fact")
    suspend fun retrieveRandomFact(): Data

    @GET("/facts")
    suspend fun retrieveListOfFacts(): BaseJSONResponse
}