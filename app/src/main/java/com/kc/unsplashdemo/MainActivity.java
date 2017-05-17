package com.kc.unsplashdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.kc.unsplash.Unsplash;
import com.kc.unsplash.api.Order;
import com.kc.unsplash.models.Photo;
import com.kc.unsplash.models.SearchResults;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String CLIENT_ID = "YOUR_CLIENT_ID";
    private Unsplash unsplash;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unsplash = new Unsplash(CLIENT_ID);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        unsplash.getPhotos(1, 10, Order.POPULAR, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                Log.d("Photos", "Photos Fetched " + photos.size());
                PhotoRecyclerAdapter adapter = new PhotoRecyclerAdapter(photos, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void search(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        String query = editText.getText().toString();

        unsplash.searchPhotos(query, new Unsplash.OnSearchCompleteListener() {
            @Override
            public void onComplete(SearchResults results) {
                Log.d("Photos", "Total Results Found " + results.getTotal());
                List<Photo> photos = results.getResults();
                PhotoRecyclerAdapter adapter = new PhotoRecyclerAdapter(photos, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {
                Log.d("Unsplash", error);
            }
        });
    }
}
