package com.kc.unsplash

import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.CollectionsEndpointInterface
import com.kc.unsplash.models.Collection
import com.kc.unsplash.models.Photo
import com.kc.unsplash.models.SearchResults

class CollectionAPI(private var collectionsApiService: CollectionsEndpointInterface) {

    fun getCollections(page: Int?,
                       perPage: Int?,
                       onComplete: (List<Collection>) -> Unit,
                       onError: (String) -> Unit) {
        val call = collectionsApiService.getCollections(page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun searchCollections(query: String,
                        page: Int = 1,
                        perPage: Int = 10,
                        onComplete: (SearchResults<Collection>) -> Unit,
                        onError: (String) -> Unit) {
        val call = collectionsApiService.search(query, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getFeaturedCollections(page: Int?,
                               perPage: Int?,
                               onComplete: (List<Collection>) -> Unit,
                               onError: (String) -> Unit) {
        val call = collectionsApiService.getFeaturedCollections(page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    @Deprecated("")
    fun getCuratedCollections(page: Int?,
                              perPage: Int?,
                              onComplete: (List<Collection>) -> Unit,
                              onError: (String) -> Unit) {
        val call = collectionsApiService.getCuratedCollections(page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getRelatedCollections(id: String,
                              onComplete: (List<Collection>) -> Unit,
                              onError: (String) -> Unit) {
        val call = collectionsApiService.getRelatedCollections(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getCollection(id: String,
                      onComplete: (Collection) -> Unit,
                      onError: (String) -> Unit) {
        val call = collectionsApiService.getCollection(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    @Deprecated("")
    fun getCuratedCollection(id: String,
                             onComplete: (Collection) -> Unit,
                             onError: (String) -> Unit) {
        val call = collectionsApiService.getCuratedCollection(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getCollectionPhotos(id: String,
                            page: Int?,
                            perPage: Int?,
                            onComplete: (List<Photo>) -> Unit,
                            onError: (String) -> Unit) {
        val call = collectionsApiService.getCollectionPhotos(id, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    @Deprecated("")
    fun getCuratedCollectionPhotos(id: String,
                                   page: Int?,
                                   perPage: Int?,
                                   onComplete: (List<Photo>) -> Unit,
                                   onError: (String) -> Unit) {
        val call = collectionsApiService.getCuratedCollectionPhotos(id, page, perPage)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun createCollection(title: String,
                         description: String?,
                         private: Boolean?,
                         onComplete: (Collection) -> Unit,
                         onError: (String) -> Unit) {
        val call = collectionsApiService.create(title, description, private)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun update(id: String,
                         title: String?,
                         description: String?,
                         private: Boolean?,
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
