package com.kc.unsplash

import com.kc.unsplash.api.Order
import com.kc.unsplash.api.Orientation
import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.PhotosEndpointInterface
import com.kc.unsplash.models.Download
import com.kc.unsplash.models.Photo
import com.kc.unsplash.models.SearchResults

class PhotoAPI(private var photosApiService: PhotosEndpointInterface) {

    fun get(page: Int?,
            perPage: Int?,
            order: Order?,
            onComplete: (List<Photo>) -> Unit,
            onError: (String) -> Unit) {
        val call = photosApiService.get(page, perPage, order?.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getCuratedPhotos(page: Int?,
                         perPage: Int?,
                         order: Order,
                         onComplete: (List<Photo>) -> Unit,
                         onError: (String) -> Unit) {
        val call = photosApiService.getCuratedPhotos(page, perPage, order.order)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getById(id: String,
                onComplete: (Photo) -> Unit,
                onError: (String) -> Unit) {
        val call = photosApiService.getById(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getRandomPhoto(collections: String?,
                        featured: Boolean? = false,
                        username: String? = null,
                        query: String? = null,
                        orientation: Orientation?,
                        onComplete: (List<Photo>) -> Unit,
                        onError: (String) -> Unit) {
        val call = photosApiService.getRandomPhotos(collections, featured, username, query, orientation?.orientation, null)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getRandomPhotos(collections: String?,
                        featured: Boolean? = false,
                        username: String? = null,
                        query: String? = null,
                        orientation: Orientation?,
                        count: Int? = 1,
                        onComplete: (List<Photo>) -> Unit,
                        onError: (String) -> Unit) {
        val call = photosApiService.getRandomPhotos(collections, featured, username, query, orientation?.orientation, count)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun search(query: String,
               page: Int? = null,
               perPage: Int? = null,
               collections: String? = null,
               orientation: String? = null,
               onComplete: (SearchResults<Photo>) -> Unit,
               onError: (String) -> Unit) {
        val call = photosApiService.search(query, page, perPage, collections, orientation)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun getDownloadLink(id: String,
                        onComplete: (Download) -> Unit,
                        onError: (String) -> Unit) {
        val call = photosApiService.getDownloadLink(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun update(id: String,
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
               onError: (String) -> Unit) {
        val call = photosApiService.update(id, latitude, longitude, name, city,
                country, confidential, make, model, exposure_time, exposure_value, focal_length, iso)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun like(id: String,
             onComplete: (Photo) -> Unit,
             onError: (String) -> Unit) {
        val call = photosApiService.like(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun unlike(id: String,
               onComplete: (Photo) -> Unit,
               onError: (String) -> Unit) {
        val call = photosApiService.unlike(id)
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

}
