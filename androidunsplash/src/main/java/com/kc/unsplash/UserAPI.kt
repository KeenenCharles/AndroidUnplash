package com.kc.unsplash

import com.kc.unsplash.api.Order
import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.UserEndpointInterface
import com.kc.unsplash.models.*
import com.kc.unsplash.models.Collection

class UserAPI(private var userApiService: UserEndpointInterface) {

    fun getCurrent(onComplete: (User) -> Unit,
                   onError: (String) -> Unit) {
        val call = userApiService.getCurrent()
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun updateCurrent(user: User,
                      onComplete: (User) -> Unit,
                      onError: (String) -> Unit) {
        val call = userApiService.updateCurrent(user)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getByUsername(username: String,
                      onComplete: (User) -> Unit,
                      onError: (String) -> Unit) {
        val call = userApiService.getByUsername(username)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getPortfolio(username: String,
                     onComplete: (Portfolio) -> Unit,
                     onError: (String) -> Unit) {
        val call = userApiService.getPortfolio(username)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getPhotos(username: String,
                  page: Int? = null,
                  perPage: Int? = null,
                  order: Order? = null,
                  stats: Boolean = false,
                  resolution: String = "days",
                  quantity: Int? = null,
                  onComplete: (List<Photo>) -> Unit,
                  onError: (String) -> Unit) {
        val call = userApiService.getPhotos(username, page, perPage, order?.order, stats, resolution, quantity)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getLikedPhotos(username: String,
                       page: Int? = null,
                       perPage: Int? = null,
                       order: Order? = null,
                       onComplete: (List<Photo>) -> Unit,
                       onError: (String) -> Unit) {
        val call = userApiService.getLikedPhotos(username, page, perPage, order?.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getCollections(username: String,
                       page: Int? = null,
                       perPage: Int? = null,
                       order: Order? = null,
                       stats: Boolean = false,
                       resolution: String = "days",
                       quantity: Int? = null,
                       onComplete: (List<Collection>) -> Unit,
                       onError: (String) -> Unit) {
        val call = userApiService.getCollections(username, page, perPage, order?.order, stats, resolution, quantity)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getStatistics(username: String,
                      resolution: String = "days",
                      quantity: Int? = null,
                      onComplete: (Stats) -> Unit,
                      onError: (String) -> Unit) {
        val call = userApiService.getStatistics(username, resolution, quantity)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun search(query: String,
               page: Int? = null,
               perPage: Int? = null,
               onComplete: (SearchResults<User>) -> Unit,
               onError: (String) -> Unit) {
        val call = userApiService.search(query, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

}
