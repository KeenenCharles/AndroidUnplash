package com.kc.unsplashdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kc.unsplash.Unsplash;
import com.kc.unsplash.api.Order;
import com.kc.unsplash.api.Scope;
import com.kc.unsplash.models.Photo;
import com.kc.unsplash.models.SearchResults;
import com.kc.unsplash.models.Token;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String CLIENT_ID = "cd532a1ce8f8e7254ae5c0acf8401b291ed5d1c88fe91a63caa7119bfe10aa52";
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

        Button login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Scope> scopes = new ArrayList<>();
                scopes.add(Scope.PUBLIC);
                scopes.add(Scope.READ_USER);
                scopes.add(Scope.WRITE_USER);
                unsplash.authorize(MainActivity.this, "example://androidunsplash/callback", scopes);
            }
        });

        Intent intent = getIntent();
        if(intent != null) {
            Uri data = intent.getData();
            if (data != null && data.getQuery() != null) {
                String code = data.getQuery().replace("code=", "");
                unsplash.getToken("b36e86b2e1bb32ee2660d1d272fecc2738471d2d2b9ee046530ad21e1d24207e", "example://androidunsplash/callback", code, new Unsplash.OnTokenLoadedListener() {
                    @Override
                    public void onComplete(Token token) {
                        Log.d("Token", token.getAccessToken());
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
            }
        }
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
