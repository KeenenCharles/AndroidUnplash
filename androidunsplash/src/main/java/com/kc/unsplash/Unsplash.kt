package com.kc.unsplash

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import com.kc.unsplash.api.HeaderInterceptor
import com.kc.unsplash.api.Scope
import com.kc.unsplash.api.UnsplashCallback
import com.kc.unsplash.api.endpoints.*
import com.kc.unsplash.models.Token
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@JvmSuppressWildcards
class Unsplash(private var clientID: String, private var token: String? = null) {

    lateinit var photos: PhotoAPI
    lateinit var collections: CollectionAPI
    lateinit var users: UserAPI
    lateinit var stats: StatsAPI

    private lateinit var authApiService: AuthEndpointInterface

    private val TAG = "AndroidUnsplash"

    init {
        createServices(clientID, token)
    }

    private fun createServices(clientId: String, token: String?) {
        val retrofit = createRetrofitClient(clientId, token)

        photos = PhotoAPI(retrofit.create(PhotosEndpointInterface::class.java))
        collections = CollectionAPI(retrofit.create(CollectionsEndpointInterface::class.java))
        users = UserAPI(retrofit.create(UserEndpointInterface::class.java))
        stats = StatsAPI(retrofit.create(StatsEndpointInterface::class.java))

        authApiService = retrofit.create(AuthEndpointInterface::class.java)
    }

    fun authorize(context: Context,
                  redirectURI: String,
                  scopeList: List<Scope>) {
        var scopes = StringBuilder()
        for (scope in scopeList) {
            scopes.append(scope.scope).append("+")
        }

        scopes = scopes.deleteCharAt(scopes.length - 1)

        val url = "https://unsplash.com/oauth/authorize?client_id=$clientID&redirect_uri=$redirectURI&response_type=code&scope=$scopes"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }

    fun getToken(clientSecret: String,
                 redirectURI: String,
                 code: String,
                 onComplete: (Token) -> Unit,
                 onError: (String) -> Unit) {
        val call = authApiService.getToken("https://unsplash.com/oauth/token", clientID, clientSecret, redirectURI, code, "authorization_code")
        call.enqueue(UnsplashCallback(onComplete, onError))
    }

    fun setToken(token: String) {
        this.token = token
        createServices(clientID, token)
    }

    private fun createRetrofitClient(clientID: String, token: String?): Retrofit {
        val builder = Retrofit.Builder()
        val headerInterceptor = HeaderInterceptor(clientID, token)

        val client = OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(logging)
        }

        return builder
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
    }

}
