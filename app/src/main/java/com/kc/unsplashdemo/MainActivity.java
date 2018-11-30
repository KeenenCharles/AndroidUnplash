package com.kc.unsplashdemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.kc.unsplash.Unsplash;
import com.kc.unsplash.api.Order;
import com.kc.unsplash.models.Photo;
import com.kc.unsplash.models.SearchResults;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String CLIENT_ID = "88b1e272f6844704b944eabaa69b2954864c203e3faa36af99dcb6590b07239a";
    private Unsplash unsplash;
    private PhotoRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unsplash = new Unsplash(CLIENT_ID);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

        adapter = new PhotoRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        unsplash.getPhotos(1, 10, Order.LATEST, new Unsplash.OnPhotosLoadedListener() {
            @Override
            public void onComplete(List<Photo> photos) {
                adapter.setPhotos(photos);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void search(View view){
        EditText editText = findViewById(R.id.editText);
        String query = editText.getText().toString();

        unsplash.searchPhotos(query, new Unsplash.OnSearchCompleteListener() {
            @Override
            public void onComplete(SearchResults results) {
                Log.d("Photos", "Total Results Found " + results.getTotal());
                List<Photo> photos = results.getResults();
                adapter.setPhotos(photos);
            }

            @Override
            public void onError(String error) {
                Log.d("Unsplash", error);
            }
        });
    }
}
