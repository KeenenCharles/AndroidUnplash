package com.keenencharles.unsplash

import com.keenencharles.unsplash.api.UnsplashCallback
import com.keenencharles.unsplash.api.UnsplashResource
import com.keenencharles.unsplash.api.UnsplashResponseHandler
import com.keenencharles.unsplash.api.endpoints.CollectionsEndpointInterface
import com.keenencharles.unsplash.models.Photo
import com.keenencharles.unsplash.models.SearchResults
import com.keenencharles.unsplash.models.Collection

@JvmSuppressWildcards
class CollectionAPI(
    private var apiService: CollectionsEndpointInterface,
    private var responseHandler: UnsplashResponseHandler
) {

    fun get(
        page: Int? = null,
        perPage: Int? = null,
        onComplete: (List<Collection>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.get(page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun get(
        page: Int? = null,
        perPage: Int? = null
    ): UnsplashResource<List<Collection>> {
        return try {
            val res = apiService.getSuspend(page, perPage)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun search(
        query: String,
        page: Int? = null,
        perPage: Int? = null,
        onComplete: (SearchResults<Collection>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.search(query, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun search(
        query: String,
        page: Int? = null,
        perPage: Int? = null
    ): UnsplashResource<SearchResults<Collection>> {
        return try {
            val res = apiService.searchSuspend(query, page, perPage)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getRelated(
        id: String,
        onComplete: (List<Collection>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getRelated(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getRelated(
        id: String
    ): UnsplashResource<List<Collection>> {
        return try {
            val res = apiService.getRelatedSuspend(id)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getById(
        id: String,
        onComplete: (Collection) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getById(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getById(
        id: String
    ): UnsplashResource<Collection> {
        return try {
            val res = apiService.getByIdSuspend(id)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun getPhotos(
        id: String,
        page: Int? = null,
        perPage: Int? = null,
        onComplete: (List<Photo>) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.getPhotos(id, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun getPhotos(
        id: String,
        page: Int? = null,
        perPage: Int? = null
    ): UnsplashResource<List<Photo>> {
        return try {
            val res = apiService.getPhotosSuspend(id, page, perPage)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun create(
        title: String,
        description: String? = null,
        private: Boolean? = null,
        onComplete: (Collection) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.create(title, description, private)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun create(
        title: String,
        description: String? = null,
        private: Boolean? = null
    ): UnsplashResource<Collection> {
        return try {
            val res = apiService.createSuspend(title, description, private)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun update(
        id: String,
        title: String? = null,
        description: String? = null,
        private: Boolean? = null,
        onComplete: (Collection) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.update(id, title, description, private)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun update(
        id: String,
        title: String? = null,
        description: String? = null,
        private: Boolean? = null
    ): UnsplashResource<Collection> {
        return try {
            val res = apiService.updateSuspend(id, title, description, private)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun delete(
        id: String,
        onComplete: (Collection) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.delete(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun delete(
        id: String,
    ): UnsplashResource<Collection> {
        return try {
            val res = apiService.deleteSuspend(id)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun addPhoto(
        collectionId: String,
        photoId: String,
        onComplete: (Collection) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.addPhoto(collectionId, photoId)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun addPhoto(
        collectionId: String,
        photoId: String
    ): UnsplashResource<Collection> {
        return try {
            val res = apiService.addPhotoSuspend(collectionId, photoId)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    fun removePhoto(
        collectionId: String,
        photoId: String,
        onComplete: (Collection) -> Unit,
        onError: (String) -> Unit
    ) {
        val call = apiService.removePhoto(collectionId, photoId)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    suspend fun removePhoto(
        collectionId: String,
        photoId: String
    ): UnsplashResource<Collection> {
        return try {
            val res = apiService.removePhotoSuspend(collectionId, photoId)
            responseHandler.handleSuccess(res)

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

}
