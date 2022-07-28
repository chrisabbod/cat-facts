package com.chrisabbod.catfacts

import retrofit2.http.GET

interface CatFactsAPI {

    @GET("/fact")
    suspend fun getRandomFact() : RandomFact
}