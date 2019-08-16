package com.kc.unsplash.api.endpoints

import com.kc.unsplash.models.Stats
import retrofit2.Call
import retrofit2.http.GET

interface StatsEndpointInterface {

    @get:GET("stats/total")
    val stats: Call<Stats>

}
