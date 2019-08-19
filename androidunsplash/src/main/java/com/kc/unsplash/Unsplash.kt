package com.kc.unsplash

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import com.kc.unsplash.api.API
import com.kc.unsplash.api.Scope
import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.*
import com.kc.unsplash.models.Stats
import com.kc.unsplash.models.Token

class Unsplash(clientId: String, token: String? = null) {

    lateinit var photos: PhotoAPI
    lateinit var collections: CollectionAPI
    lateinit var users: UserAPI
    lateinit var stats: StatsAPI

    private lateinit var authApiService: AuthEndpointInterface

    private var mClientID = ""
    private var mToken: String? = null
    private lateinit var API: API

    private val TAG = "Unsplash"

    init {
        mClientID = clientId
        mToken = token
        createServices(clientId, null)
    }

    private fun createServices(clientId: String, token: String?) {
        API = API(clientId, null)
        photos = PhotoAPI(API.retrofit.create(PhotosEndpointInterface::class.java))
        collections = CollectionAPI(API.retrofit.create(CollectionsEndpointInterface::class.java))
        users = UserAPI(API.retrofit.create(UserEndpointInterface::class.java))
        stats = StatsAPI(API.retrofit.create(StatsEndpointInterface::class.java))

        authApiService = API.retrofit.create(AuthEndpointInterface::class.java)
    }

    fun authorize(context: Context,
                  redirectURI: String,
                  scopeList: List<Scope>) {
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

    fun getToken(clientSecret: String,
                 redirectURI: String,
                 code: String,
                 onComplete: (Token) -> Unit,
                 onError: (String) -> Unit) {
        val call = authApiService.getToken("https://unsplash.com/oauth/token", mClientID, clientSecret, redirectURI, code, "authorization_code")
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun setToken(token: String) {
        mToken = token
        createServices(mClientID, token)
    }

}
