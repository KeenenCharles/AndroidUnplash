package com.keenencharles.unsplash

import com.keenencharles.unsplash.api.UnsplashCallback
import com.keenencharles.unsplash.api.endpoints.CollectionsEndpointInterface
import com.keenencharles.unsplash.models.Photo
import com.keenencharles.unsplash.models.SearchResults
import com.keenencharles.unsplash.models.Collection

@JvmSuppressWildcards
class CollectionAPI(private var collectionsApiService: CollectionsEndpointInterface) {

    fun get(page: Int? = null,
            perPage: Int? = null,
            onComplete: (List<Collection>) -> Unit,
            onError: (String) -> Unit) {
        val call = collectionsApiService.get(page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun search(query: String,
               page: Int? = null,
               perPage: Int? = null,
               onComplete: (SearchResults<Collection>) -> Unit,
               onError: (String) -> Unit) {
        val call = collectionsApiService.search(query, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getRelated(id: String,
                   onComplete: (List<Collection>) -> Unit,
                   onError: (String) -> Unit) {
        val call = collectionsApiService.getRelated(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getById(id: String,
                onComplete: (Collection) -> Unit,
                onError: (String) -> Unit) {
        val call = collectionsApiService.getById(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getPhotos(id: String,
                  page: Int? = null,
                  perPage: Int? = null,
                  onComplete: (List<Photo>) -> Unit,
                  onError: (String) -> Unit) {
        val call = collectionsApiService.getPhotos(id, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun create(title: String,
               description: String? = null,
               private: Boolean? = null,
               onComplete: (Collection) -> Unit,
               onError: (String) -> Unit) {
        val call = collectionsApiService.create(title, description, private)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun update(id: String,
               title: String? = null,
               description: String? = null,
               private: Boolean? = null,
               onComplete: (Collection) -> Unit,
               onError: (String) -> Unit) {
        val call = collectionsApiService.update(id, title, description, private)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun delete(id: String,
                         onComplete: (Collection) -> Unit,
                         onError: (String) -> Unit) {
        val call = collectionsApiService.delete(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun addPhoto(collectionId: String,
                 photoId: String,
                 onComplete: (Collection) -> Unit,
                 onError: (String) -> Unit) {
        val call = collectionsApiService.addPhoto(collectionId, photoId)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun removePhoto(collectionId: String,
                    photoId: String,
                    onComplete: (Collection) -> Unit,
                    onError: (String) -> Unit) {
        val call = collectionsApiService.removePhoto(collectionId, photoId)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

}
