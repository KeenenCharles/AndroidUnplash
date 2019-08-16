package com.kc.unsplash

import androidx.browser.customtabs.CustomTabsIntent

import android.content.Context
import android.net.Uri
import android.util.Log

import com.kc.unsplash.api.Scope
import com.kc.unsplash.api.endpoints.AuthEndpointInterface
import com.kc.unsplash.api.endpoints.CollectionsEndpointInterface
import com.kc.unsplash.api.endpoints.StatsEndpointInterface
import com.kc.unsplash.api.HeaderInterceptor
import com.kc.unsplash.api.Order
import com.kc.unsplash.api.endpoints.PhotosEndpointInterface
import com.kc.unsplash.models.*
import com.kc.unsplash.models.Collection

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Unsplash(clientId: String) {

    private lateinit var photosApiService: PhotosEndpointInterface
    private lateinit var collectionsApiService: CollectionsEndpointInterface
    private lateinit var statsApiService: StatsEndpointInterface
    private lateinit var authApiService: AuthEndpointInterface

    private var mClientID = ""
    private var mToken: String? = null

    private val TAG = "Unsplash"

    init {
        mClientID = clientId
        createServices(clientId, null)
    }

    private fun createServices(clientId: String, token: String?) {
        val headerInterceptor = HeaderInterceptor(clientId, token)

        val client = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor).build()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        photosApiService = retrofit.create(PhotosEndpointInterface::class.java)
        collectionsApiService = retrofit.create(CollectionsEndpointInterface::class.java)
        statsApiService = retrofit.create(StatsEndpointInterface::class.java)
        authApiService = retrofit.create(AuthEndpointInterface::class.java)
    }

    fun authorize(context: Context, redirectURI: String, scopeList: List<Scope>) {
        var scopes = StringBuilder()
        for (scope in scopeList) {
            scopes.append(scope.scope).append("+")
        }

        scopes = scopes.deleteCharAt(scopes.length - 1)

        val url = "https://unsplash.com/oauth/authorize?client_id=$mClientID&redirect_uri=$redirectURI&response_type=code&scope=$scopes"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }

    fun getToken(clientSecret: String, redirectURI: String, code: String, listener: OnTokenLoadedListener) {
        val call = authApiService.getToken("https://unsplash.com/oauth/token", mClientID, clientSecret, redirectURI, code, "authorization_code")
        call.enqueue(getTokenCallback(listener))
    }

    fun setToken(token: String) {
        mToken = token
        createServices(mClientID, token)
    }

    fun getPhotos(page: Int?, perPage: Int?, order: Order, listener: OnPhotosLoadedListener) {
        val call = photosApiService.getPhotos(page, perPage, order.order)
        call.enqueue(getMultiplePhotoCallback(listener))
    }

    @Deprecated("")
    fun getCuratedPhotos(page: Int?, perPage: Int?, order: Order, listener: OnPhotosLoadedListener) {
        val call = photosApiService.getCuratedPhotos(page, perPage, order.order)
        call.enqueue(getMultiplePhotoCallback(listener))
    }

    fun getPhoto(id: String, listener: OnPhotoLoadedListener) {
        getPhoto(id, null, null, listener)
    }

    fun getRandomPhoto(collections: String?,
                       featured: Boolean?, username: String?,
                       query: String?, width: Int?,
                       height: Int?, orientation: String?, listener: OnPhotoLoadedListener) {
        val call = photosApiService.getRandomPhoto(collections!!, featured, username!!, query!!, width, height, orientation!!)
        call.enqueue(getSinglePhotoCallback(listener))
    }

    fun getRandomPhotos(collections: String?,
                        featured: Boolean?, username: String?,
                        query: String?, width: Int?,
                        height: Int?, orientation: String?,
                        count: Int?, listener: OnPhotosLoadedListener) {
        val call = photosApiService.getRandomPhotos(collections!!, featured!!, username!!, query!!, width, height, orientation!!, count)
        call.enqueue(getMultiplePhotoCallback(listener))
    }

    fun searchPhotos(query: String, page: Int = 1, perPage: Int = 10, orientation: String? = null, listener: OnSearchCompleteListener) {
        val call = photosApiService.searchPhotos(query, page, perPage, orientation)
        call.enqueue(getSearchResultsCallback(listener))
    }

    fun getPhotoDownloadLink(id: String, listener: OnLinkLoadedListener) {
        val call = photosApiService.getPhotoDownloadLink(id)
        call.enqueue(object : UnsplashCallback<Download>() {
            override fun onComplete(response: Download?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<Download>, message: String) {
                listener.onError(message)
            }
        }
        )
    }

    fun getPhoto(id: String, width: Int?, height: Int?, listener: OnPhotoLoadedListener) {
        val call = photosApiService.getPhoto(id, width, height)
        call.enqueue(getSinglePhotoCallback(listener))
    }

    fun getCollections(page: Int?, perPage: Int?, listener: OnCollectionsLoadedListener) {
        val call = collectionsApiService.getCollections(page, perPage)
        call.enqueue(getMultipleCollectionsCallback(listener))
    }

    fun getFeaturedCollections(page: Int?, perPage: Int?, listener: OnCollectionsLoadedListener) {
        val call = collectionsApiService.getFeaturedCollections(page, perPage)
        call.enqueue(getMultipleCollectionsCallback(listener))
    }

    @Deprecated("")
    fun getCuratedCollections(page: Int?, perPage: Int?, listener: OnCollectionsLoadedListener) {
        val call = collectionsApiService.getCuratedCollections(page, perPage)
        call.enqueue(getMultipleCollectionsCallback(listener))
    }

    fun getRelatedCollections(id: String, listener: OnCollectionsLoadedListener) {
        val call = collectionsApiService.getRelatedCollections(id)
        call.enqueue(getMultipleCollectionsCallback(listener))
    }

    fun getCollection(id: String, listener: OnCollectionLoadedListener) {
        val call = collectionsApiService.getCollection(id)
        call.enqueue(getSingleCollectionCallback(listener))
    }

    @Deprecated("")
    fun getCuratedCollection(id: String, listener: OnCollectionLoadedListener) {
        val call = collectionsApiService.getCuratedCollection(id)
        call.enqueue(getSingleCollectionCallback(listener))
    }

    fun getCollectionPhotos(id: String, page: Int?, perPage: Int?, listener: OnPhotosLoadedListener) {
        val call = collectionsApiService.getCollectionPhotos(id, page, perPage)
        call.enqueue(getMultiplePhotoCallback(listener))
    }

    @Deprecated("")
    fun getCuratedCollectionPhotos(id: String, page: Int?, perPage: Int?, listener: OnPhotosLoadedListener) {
        val call = collectionsApiService.getCuratedCollectionPhotos(id, page, perPage)
        call.enqueue(getMultiplePhotoCallback(listener))
    }

    fun getStats(listener: OnStatsLoadedListener) {
        val call = statsApiService.stats
        call.enqueue(object : UnsplashCallback<Stats>() {
            override fun onComplete(response: Stats?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<Stats>, message: String) {
                listener.onError(message)
            }
        }
        )
    }

    // CALLBACKS

    private fun getSinglePhotoCallback(listener: OnPhotoLoadedListener): Callback<Photo> {
        return object : UnsplashCallback<Photo>() {
            override fun onComplete(response: Photo?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<Photo>, message: String) {
                listener.onError(message)
            }
        }
    }

    private fun getMultiplePhotoCallback(listener: OnPhotosLoadedListener): Callback<List<Photo>> {
        return object : UnsplashCallback<List<Photo>>() {
            override fun onComplete(response: List<Photo>?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<List<Photo>>, message: String) {
                Log.d(TAG, "Url = " + call.request().url())
                listener.onError(message)
            }
        }
    }

    private fun getSingleCollectionCallback(listener: OnCollectionLoadedListener): Callback<Collection> {
        return object : UnsplashCallback<Collection>() {
            override fun onComplete(response: Collection?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<Collection>, message: String) {
                listener.onError(message)
            }
        }
    }

    private fun getSearchResultsCallback(listener: OnSearchCompleteListener): Callback<SearchResults> {
        return object : UnsplashCallback<SearchResults>() {
            override fun onComplete(response: SearchResults?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<SearchResults>, message: String) {
                listener.onError(message)
            }
        }
    }

    private fun getMultipleCollectionsCallback(listener: OnCollectionsLoadedListener): Callback<List<Collection>> {
        return object : UnsplashCallback<List<Collection>>() {
            override fun onComplete(response: List<Collection>?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<List<Collection>>, message: String) {
                listener.onError(message)
            }
        }
    }

    private fun getTokenCallback(listener: OnTokenLoadedListener): Callback<Token> {
        return object : UnsplashCallback<Token>() {
            override fun onComplete(response: Token?) {
                listener.onComplete(response!!)
            }

            override fun onError(call: Call<Token>, message: String) {
                listener.onError(message)
            }
        }
    }

    private abstract inner class UnsplashCallback<T> : Callback<T> {

        internal abstract fun onComplete(response: T?)

        internal abstract fun onError(call: Call<T>, message: String)

        override fun onResponse(call: Call<T>, response: Response<T>) {
            val statusCode = response.code()
            Log.d(TAG, "Status Code = $statusCode")
            if (statusCode == 200) {
                onComplete(response.body())
            } else if (statusCode >= 400) {
                onError(call, statusCode.toString())

                if (statusCode == 401) {
                    Log.d(TAG, "Unauthorized, Check your client Id")
                }
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onError(call, t.message!!)
        }
    }

    interface OnPhotosLoadedListener {
        fun onComplete(photos: List<Photo>)

        fun onError(error: String)
    }

    interface OnSearchCompleteListener {
        fun onComplete(results: SearchResults)

        fun onError(error: String)
    }

    interface OnPhotoLoadedListener {
        fun onComplete(photo: Photo)

        fun onError(error: String)
    }

    interface OnLinkLoadedListener {

        fun onComplete(downloadLink: Download)

        fun onError(error: String)
    }

    interface OnCollectionsLoadedListener {
        fun onComplete(collections: List<Collection>)

        fun onError(error: String)
    }

    interface OnCollectionLoadedListener {
        fun onComplete(photos: Collection)

        fun onError(error: String)
    }

    interface OnStatsLoadedListener {
        fun onComplete(stats: Stats)

        fun onError(error: String)
    }

    interface OnTokenLoadedListener {
        fun onComplete(token: Token)

        fun onError(error: String)
    }

    companion object {

        private val BASE_URL = "https://api.unsplash.com/"

        val ORIENTATION_PORTRAIT = "portrait"
        val ORIENTATION_LANDSCAPE = "landscape"
        val ORIENTATION_SQUARISH = "squarish"
    }
}
