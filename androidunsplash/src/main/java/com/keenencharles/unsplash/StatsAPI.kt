package com.keenencharles.unsplash

import com.keenencharles.unsplash.api.UnsplashCallback
import com.keenencharles.unsplash.api.UnsplashResource
import com.keenencharles.unsplash.api.UnsplashResponseHandler
import com.keenencharles.unsplash.api.endpoints.StatsEndpointInterface
import com.keenencharles.unsplash.models.Stats

@JvmSuppressWildcards
class StatsAPI(
    private var apiService: StatsEndpointInterface,
    private var responseHandler: UnsplashResponseHandler
) {

    fun getTotal(
        onComplete: (Stats) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getTotal()
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getTotal(): UnsplashResource<Stats> {
        return try {
            val res = apiService.getTotalSuspend()
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getMonth(
        onComplete: (Stats) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getMonth()
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getMonth(): UnsplashResource<Stats> {
        return try {
            val res = apiService.getMonthSuspend()
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}
