package com.kc.unsplashdemo

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
import com.kc.unsplash.Unsplash
import com.kc.unsplash.api.Order
import com.kc.unsplash.api.Scope
import com.kc.unsplashdemo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private val redirectURI = "example://androidunsplash/callback"

    private lateinit var unsplash: Unsplash

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var adapter: PhotoAdapter
    private lateinit var sharedPref: SharedPreferences

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

        unsplash.photos.get(1, 10, Order.LATEST, {adapter.updateList(it)}, {})

        handleAuthCallback()
    }

    private fun handleAuthCallback() {
        val data = intent.data
        val code = data?.query?.replace("code=", "")

        code?.let {
            unsplash.getToken(BuildConfig.UnsplashSecret, redirectURI, code, {
                        Log.d("Token", it.accessToken)
                        unsplash.setToken(it.accessToken)
                        sharedPref.edit().putString("TOKEN", it.accessToken).apply()
                    },
                    {
                        Log.d("Token", it)
                    }
            )
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
                Log.d("Photos", "Total Results Found " + it.total!!)
                val photos = it.results
                adapter.updateList(photos)
            },
            onError = {
                Log.d("Unsplash", it)
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
