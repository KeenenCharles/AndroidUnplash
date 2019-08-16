package com.kc.unsplashdemo

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
import com.kc.unsplash.models.Photo
import com.kc.unsplash.models.SearchResults
import com.kc.unsplash.models.Token
import com.kc.unsplashdemo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private val CLIENT_ID = "63ca119bfe10aa51ce8f8e2cd532ad5d1c88f7254ae5c0aa7cf8401b291ee91a"
    private val CLIENT_SECRET = "7e86b2e1bb32ee2660d1d272fecc27e046530ad1d2d2b9e21e1d24b36384207e"

    private val redirectURI = "example://androidunsplash/callback"

    private var unsplash: Unsplash? = null

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        unsplash = Unsplash(CLIENT_ID)

        mBinding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)

        adapter = PhotoAdapter {}
        mBinding.recyclerView.adapter = adapter

        unsplash!!.getPhotos(1, 10, Order.LATEST, object : Unsplash.OnPhotosLoadedListener {
            override fun onComplete(photos: List<Photo>) {
                adapter.updateList(photos)
            }

            override fun onError(error: String) {

            }
        })

        mBinding.searchButton.setOnClickListener {
            search()
        }

        authCallback()
    }

    private fun authCallback() {
       intent?.let {
            val data = intent.data
            if (data != null && data.query != null) {
                val code = data.query!!.replace("code=", "")

                unsplash!!.getToken(CLIENT_SECRET, redirectURI, code, object : Unsplash.OnTokenLoadedListener {
                    override fun onComplete(token: Token) {
                        Log.d("Token", token.accessToken)
                        unsplash!!.setToken(token.accessToken)
                    }

                    override fun onError(error: String) {

                    }
                })
            }
        }
    }

    private fun authorize() {
        val scopes = ArrayList<Scope>()
        scopes.add(Scope.PUBLIC)
        scopes.add(Scope.READ_USER)
        scopes.add(Scope.WRITE_USER)
        unsplash!!.authorize(this@MainActivity, redirectURI, scopes)
    }

    private fun search() {
        val query = mBinding.editText.text.toString()

        unsplash!!.searchPhotos(query, listener = object : Unsplash.OnSearchCompleteListener {
            override fun onComplete(results: SearchResults) {
                Log.d("Photos", "Total Results Found " + results.total!!)
                val photos = results.results
                adapter.updateList(photos)
            }

            override fun onError(error: String) {
                Log.d("Unsplash", error)
            }
        })
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
