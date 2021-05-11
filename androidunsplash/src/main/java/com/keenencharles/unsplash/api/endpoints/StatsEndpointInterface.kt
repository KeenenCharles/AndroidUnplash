package com.keenencharles.unsplash.api.endpoints

import com.keenencharles.unsplash.models.Stats
import retrofit2.Call
import retrofit2.http.GET

interface StatsEndpointInterface {

    @GET("stats/total")
    fun getTotal(): Call<Stats>

    @GET("stats/month")
    fun getMonth(): Call<Stats>

}
