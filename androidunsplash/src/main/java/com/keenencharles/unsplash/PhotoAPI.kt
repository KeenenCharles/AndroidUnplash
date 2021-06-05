package com.keenencharles.unsplash

import com.keenencharles.unsplash.api.UnsplashCallback
import com.keenencharles.unsplash.api.UnsplashResource
import com.keenencharles.unsplash.api.UnsplashResponseHandler
import com.keenencharles.unsplash.api.endpoints.PhotosEndpointInterface
import com.keenencharles.unsplash.models.*

@JvmSuppressWildcards
class PhotoAPI(
    private var apiService: PhotosEndpointInterface,
    private var responseHandler: UnsplashResponseHandler
) {

    fun get(
        page: Int?,
        perPage: Int?,
        order: Order?,
        onComplete: (List<Photo>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.get(page, perPage, order?.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun get(
        page: Int?,
        perPage: Int?,
        order: Order?
    ): UnsplashResource<List<Photo>> {
        return try {
            val res = apiService.getSuspend(page, perPage, order?.order)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getById(
        id: String,
        onComplete: (Photo) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getById(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getById(
        id: String
    ): UnsplashResource<Photo> {
        return try {
            val res = apiService.getByIdSuspend(id)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getRandomPhoto(
        collections: String? = null,
        featured: Boolean? = false,
        username: String? = null,
        query: String? = null,
        orientation: Orientation? = null,
        contentFilter: ContentFilter? = null,
        onComplete: (Photo) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getRandomPhoto(
            collections,
            featured,
            username,
            query,
            orientation?.orientation,
            contentFilter?.type
        )
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getRandomPhoto(
        collections: String? = null,
        featured: Boolean? = false,
        username: String? = null,
        query: String? = null,
        orientation: Orientation? = null,
        contentFilter: ContentFilter? = null
    ): UnsplashResource<Photo> {
        return try {
            val res = apiService.getRandomPhotoSuspend(
                collections,
                featured,
                username,
                query,
                orientation?.orientation,
                contentFilter?.type
            )
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getRandomPhotos(
        collections: String? = null,
        featured: Boolean? = false,
        username: String? = null,
        query: String? = null,
        orientation: Orientation? = null,
        count: Int = 1,
        contentFilter: ContentFilter? = null,
        onComplete: (List<Photo>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getRandomPhotos(
            collections,
            featured,
            username,
            query,
            orientation?.orientation,
            count,
            contentFilter?.type
        )
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getRandomPhotos(
        collections: String? = null,
        featured: Boolean? = false,
        username: String? = null,
        query: String? = null,
        orientation: Orientation? = null,
        count: Int = 1,
        contentFilter: ContentFilter? = null
    ): UnsplashResource<List<Photo>> {
        return try {
            val res = apiService.getRandomPhotosSuspend(
                collections,
                featured,
                username,
                query,
                orientation?.orientation,
                count,
                contentFilter?.type
            )
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun search(
        query: String,
        page: Int? = null,
        perPage: Int? = null,
        collections: String? = null,
        orientation: Orientation? = null,
        contentFilter: ContentFilter? = null,
        color: Color? = null,
        onComplete: (SearchResults<Photo>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.search(
            query,
            page,
            perPage,
            collections,
            orientation?.orientation,
            contentFilter?.type,
            color?.color
        )
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun search(
        query: String,
        page: Int? = null,
        perPage: Int? = null,
        collections: String? = null,
        orientation: Orientation? = null,
        contentFilter: ContentFilter? = null,
        color: Color? = null
    ): UnsplashResource<SearchResults<Photo>> {
        return try {
            val res = apiService.searchSuspend(
                query,
                page,
                perPage,
                collections,
                orientation?.orientation,
                contentFilter?.type,
                color?.color
            )
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getDownloadLink(
        id: String,
        onComplete: (Download) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getDownloadLink(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getDownloadLink(
        id: String
    ): UnsplashResource<Download> {
        return try {
            val res = apiService.getDownloadLinkSuspend(id)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun update(
        id: String,
        latitude: String? = null,
        longitude: String? = null,
        name: String? = null,
        city: String? = null,
        country: String? = null,
        confidential: String? = null,
        make: String? = null,
        model: String? = null,
        exposure_time: String? = null,
        exposure_value: String? = null,
        focal_length: String? = null,
        iso: String? = null,
        onComplete: (Photo) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.update(
            id, latitude, longitude, name, city,
            country, confidential, make, model, exposure_time, exposure_value, focal_length, iso
        )
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun update(
        id: String,
        latitude: String? = null,
        longitude: String? = null,
        name: String? = null,
        city: String? = null,
        country: String? = null,
        confidential: String? = null,
        make: String? = null,
        model: String? = null,
        exposure_time: String? = null,
        exposure_value: String? = null,
        focal_length: String? = null,
        iso: String? = null
    ): UnsplashResource<Photo> {
        return try {
            val res = apiService.updateSuspend(
                id, latitude, longitude, name, city,
                country, confidential, make, model, exposure_time, exposure_value, focal_length, iso
            )
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun like(
        id: String,
        onComplete: (Photo) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.like(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun like(
        id: String,
    ): UnsplashResource<Photo> {
        return try {
            val res = apiService.likeSuspend(id)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun unlike(
        id: String,
        onComplete: (Photo) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.unlike(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun unlike(
        id: String,
    ): UnsplashResource<Photo> {
        return try {
            val res = apiService.unlikeSuspend(id)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}
