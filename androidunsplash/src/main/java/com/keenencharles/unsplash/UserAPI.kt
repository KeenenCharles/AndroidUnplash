package com.keenencharles.unsplash

import com.keenencharles.unsplash.models.Order
import com.keenencharles.unsplash.api.UnsplashCallback
import com.keenencharles.unsplash.api.UnsplashResource
import com.keenencharles.unsplash.api.UnsplashResponseHandler
import com.keenencharles.unsplash.api.endpoints.UserEndpointInterface
import com.keenencharles.unsplash.models.*
import com.keenencharles.unsplash.models.Collection

@JvmSuppressWildcards
class UserAPI(
    private var apiService: UserEndpointInterface,
    private var responseHandler: UnsplashResponseHandler
) {

    fun getCurrent(
        onComplete: (User) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getCurrent()
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getCurrent(): UnsplashResource<User> {
        return try {
            val res = apiService.getCurrentSuspend()
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun updateCurrent(
        user: User,
        onComplete: (User) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.updateCurrent(user)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun updateCurrent(
        user: User
    ): UnsplashResource<User> {
        return try {
            val res = apiService.updateCurrentSuspend(user)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getByUsername(
        username: String,
        onComplete: (User) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getByUsername(username)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getByUsername(
        username: String
    ): UnsplashResource<User> {
        return try {
            val res = apiService.getByUsernameSuspend(username)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getPortfolio(
        username: String,
        onComplete: (Portfolio) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getPortfolio(username)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getPortfolio(
        username: String
    ): UnsplashResource<Portfolio> {
        return try {
            val res = apiService.getPortfolioSuspend(username)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getPhotos(
        username: String,
        page: Int? = null,
        perPage: Int? = null,
        order: Order? = null,
        stats: Boolean = false,
        resolution: String = "days",
        quantity: Int? = null,
        onComplete: (List<Photo>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getPhotos(
            username,
            page,
            perPage,
            order?.order,
            stats,
            resolution,
            quantity
        )
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getPhotos(
        username: String,
        page: Int? = null,
        perPage: Int? = null,
        order: Order? = null,
        stats: Boolean = false,
        resolution: String = "days",
        quantity: Int? = null
    ): UnsplashResource<List<Photo>> {
        return try {
            val res = apiService.getPhotosSuspend(
                username,
                page,
                perPage,
                order?.order,
                stats,
                resolution,
                quantity
            )
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getLikedPhotos(
        username: String,
        page: Int? = null,
        perPage: Int? = null,
        order: Order? = null,
        onComplete: (List<Photo>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getLikedPhotos(username, page, perPage, order?.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getLikedPhotos(
        username: String,
        page: Int? = null,
        perPage: Int? = null,
        order: Order? = null
    ): UnsplashResource<List<Photo>> {
        return try {
            val res = apiService.getLikedPhotosSuspend(username, page, perPage, order?.order)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getCollections(
        username: String,
        page: Int? = null,
        perPage: Int? = null,
        order: Order? = null,
        stats: Boolean = false,
        resolution: String = "days",
        quantity: Int? = null,
        onComplete: (List<Collection>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getCollections(
            username,
            page,
            perPage,
            order?.order,
            stats,
            resolution,
            quantity
        )
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getCollections(
        username: String,
        page: Int? = null,
        perPage: Int? = null,
        order: Order? = null,
        stats: Boolean = false,
        resolution: String = "days",
        quantity: Int? = null
    ): UnsplashResource<List<Collection>> {
        return try {
            val res = apiService.getCollectionsSuspend(
                username,
                page,
                perPage,
                order?.order,
                stats,
                resolution,
                quantity
            )
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getStatistics(
        username: String,
        resolution: String = "days",
        quantity: Int? = null,
        onComplete: (Stats) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getStatistics(username, resolution, quantity)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getStatistics(
        username: String,
        resolution: String = "days",
        quantity: Int? = null
    ): UnsplashResource<Stats> {
        return try {
            val res = apiService.getStatisticsSuspend(username, resolution, quantity)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun search(
        query: String,
        page: Int? = null,
        perPage: Int? = null,
        onComplete: (SearchResults<User>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.search(query, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun search(
        query: String,
        page: Int? = null,
        perPage: Int? = null
    ): UnsplashResource<SearchResults<User>> {
        return try {
            val res = apiService.searchSuspend(query, page, perPage)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}
