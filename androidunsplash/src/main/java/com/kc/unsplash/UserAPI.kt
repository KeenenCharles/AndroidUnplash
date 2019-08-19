package com.kc.unsplash

import com.kc.unsplash.api.Order
import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.UserEndpointInterface
import com.kc.unsplash.models.*
import com.kc.unsplash.models.Collection

class UserAPI(private var userApiService: UserEndpointInterface) {

    fun getCurrentUser(onComplete: (User) -> Unit,
                       onError: (String) -> Unit) {
        val call = userApiService.getCurrentUser()
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun updateCurrentUser(user: User,
                          onComplete: (User) -> Unit,
                          onError: (String) -> Unit) {
        val call = userApiService.updateCurrentUser(user)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getUser(username: String,
                onComplete: (User) -> Unit,
                onError: (String) -> Unit) {
        val call = userApiService.getUser(username)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getUserPortfolio(username: String,
                         onComplete: (Portfolio) -> Unit,
                         onError: (String) -> Unit) {
        val call = userApiService.getUserPortfolio(username)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getUserPhotos(username: String,
                      page: Int? = 1,
                      perPage: Int? = 10,
                      order: Order = Order.LATEST,
                      stats: Boolean = false,
                      resolution: String = "days",
                      quantity: Int? = 30,
                      onComplete: (List<Photo>) -> Unit,
                      onError: (String) -> Unit) {
        val call = userApiService.getUserPhotos(username, page, perPage, order.order, stats, resolution, quantity)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getUserLikedPhotos(username: String,
                      page: Int? = 1,
                      perPage: Int? = 10,
                      order: Order = Order.LATEST,
                      onComplete: (List<Photo>) -> Unit,
                      onError: (String) -> Unit) {
        val call = userApiService.getUserLikedPhotos(username, page, perPage, order.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getUserCollections(username: String,
                          page: Int? = 1,
                          perPage: Int? = 10,
                          order: Order = Order.LATEST,
                          stats: Boolean = false,
                          resolution: String = "days",
                          quantity: Int? = 30,
                          onComplete: (List<Collection>) -> Unit,
                          onError: (String) -> Unit) {
        val call = userApiService.getUserCollections(username, page, perPage, order.order, stats, resolution, quantity)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getUserStatistics(username: String,
                          resolution: String = "days",
                          quantity: Int? = 30,
                          onComplete: (Stats) -> Unit,
                          onError: (String) -> Unit) {
        val call = userApiService.getUserStatistics(username, resolution, quantity)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun searchUsers(query: String,
                    page: Int = 1,
                    perPage: Int = 10,
                    onComplete: (SearchResults<User>) -> Unit,
                    onError: (String) -> Unit) {
        val call = userApiService.searchUsers(query, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

}
