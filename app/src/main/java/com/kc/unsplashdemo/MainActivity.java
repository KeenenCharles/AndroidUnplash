package com.kc.unsplashdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.kc.unsplash.Unsplash;
import com.kc.unsplash.models.Photo;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private final String CLIENT_ID = "YOUR_CLIENT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Unsplash unsplash = new Unsplash(CLIENT_ID);
        unsplash.getPhoto("82gJggDId-U", new Unsplash.OnPhotoLoadedListener() {
            @Override
            public void onComplete(Photo photo) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Picasso.with(MainActivity.this).load(photo.getUrls().getRegular()).into(imageView);
            }

            @Override
            public void onError(String error) {
                Log.v("Error", error);
            }
        });
    }
}
