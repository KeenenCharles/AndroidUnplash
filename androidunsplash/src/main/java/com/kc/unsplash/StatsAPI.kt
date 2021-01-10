package com.kc.unsplash

import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.StatsEndpointInterface
import com.kc.unsplash.models.Stats
import com.kc.unsplash.models.User

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
