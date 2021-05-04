package com.keenencharles.unsplash

import com.keenencharles.unsplash.api.UnsplashCallback
import com.keenencharles.unsplash.api.endpoints.StatsEndpointInterface
import com.keenencharles.unsplash.models.Stats
import com.keenencharles.unsplash.models.User

@JvmSuppressWildcards
class StatsAPI(private var statsApiService: StatsEndpointInterface) {

    fun getTotal(onComplete: (Stats) -> Unit,
                 onError: (String) -> Unit) {
        val call = statsApiService.getTotal()
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getMonth(onComplete: (Stats) -> Unit,
                 onError: (String) -> Unit) {
        val call = statsApiService.getMonth()
        call.enqueue(UnsplashCallback(onComplete, onError))
    }
}
