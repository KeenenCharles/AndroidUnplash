package com.keenencharles.unsplashdemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.keenencharles.unsplash.Unsplash
import com.keenencharles.unsplash.models.Order
import com.keenencharles.unsplash.api.Scope
import com.keenencharles.unsplash.api.UnsplashResource
import com.keenencharles.unsplashdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {

    private val redirectURI = "example://androidunsplash/callback"

    private lateinit var unsplash: Unsplash

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var adapter: PhotoAdapter
    private lateinit var sharedPref: SharedPreferences

    private val TAG = "AndroidUnsplash"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        adapter = PhotoAdapter {}
        mBinding.recyclerView.adapter = adapter

        mBinding.searchButton.setOnClickListener {
            search()
        }

        sharedPref = getPreferences(Context.MODE_PRIVATE)

        val token = sharedPref.getString("TOKEN", null)
        unsplash = Unsplash(BuildConfig.UnsplashID, token)

        fetchPhotos()

        handleAuthCallback()
    }

    private fun fetchPhotos() {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val res = unsplash.photos.get(1, 10, Order.LATEST)

                if (res is UnsplashResource.Success) {
                    withContext(Dispatchers.Main) {
                        adapter.updateList(res.data!!)
                    }
                }
                else if (res is UnsplashResource.Error) {
                    Log.d(TAG, res.errorMessage)
                }
            }
        }
    }

    private fun handleAuthCallback() {
        val data = intent.data
        val code = data?.query?.replace("code=", "")

        code?.let { fetchToken(code) }
    }

    private fun fetchToken(code: String) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                val res = unsplash.getToken(BuildConfig.UnsplashSecret, redirectURI, code)

                val token = res.data!!.accessToken

                if (res is UnsplashResource.Success) {
                    Log.d(TAG, token)
                    unsplash.setToken(token)
                    sharedPref.edit().putString("TOKEN", token).apply()
                } else if (res is UnsplashResource.Error) {
                    Log.d(TAG, res.errorMessage)
                }
            }
        }
    }

    private fun authorize() {
        val scopes = listOf(Scope.PUBLIC, Scope.READ_USER, Scope.WRITE_USER)
        unsplash.authorize(this@MainActivity, redirectURI, scopes)
    }

    private fun search() {
        val query = mBinding.editText.text.toString()

        unsplash.photos.search(query,
            onComplete = {
                Log.d(TAG, "Total Results Found " + it.total!!)
                val photos = it.results
                adapter.updateList(photos)
            },
            onError = {
                Log.d(TAG, it)
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sign_in -> {
                authorize()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
