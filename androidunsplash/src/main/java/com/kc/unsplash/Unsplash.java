package com.kc.unsplash;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.kc.unsplash.models.Photo;
import com.kc.unsplash.net.HeaderInterceptor;
import com.kc.unsplash.net.Order;
import com.kc.unsplash.net.UnsplashApiEndpointInterface;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Unsplash {

    public static final String BASE_URL = "https://api.unsplash.com/";

    private String clientId;
    private UnsplashApiEndpointInterface apiService;

    public Unsplash(String clientId) {
        this.clientId = clientId;

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor(clientId)).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(UnsplashApiEndpointInterface.class);
    }

    public void getPhotos(int page, int perPage, Order order, final OnPhotosLoadedListener listener){
        Call<List<Photo>> call = apiService.getPhotos(page, perPage, order.getOrder());
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                int statusCode = response.code();
                if(statusCode == 200) {
                    List<Photo> photos = response.body();
                    listener.onComplete(photos);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                // Log error here since request failed
                Log.d("Getting Photos", "Failure");
                listener.onError(t.getMessage());
            }
        });
    }

    public void getCuratedPhotos(int page, int perPage, Order order, final OnPhotosLoadedListener listener){
        Call<List<Photo>> call = apiService.getCuratedPhotos(page, perPage, order.getOrder());
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                int statusCode = response.code();
                if(statusCode == 200) {
                    List<Photo> photos = response.body();
                    listener.onComplete(photos);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                // Log error here since request failed
                listener.onError(t.getMessage());
            }
        });
    }

    public void getPhoto(@NonNull String id, final OnPhotoLoadedListener listener){
        getPhoto(id, null, null, listener);
    }

    public void getPhoto(@NonNull String id, @Nullable Integer width, @Nullable Integer height, final OnPhotoLoadedListener listener){
        Call<Photo> call = apiService.getPhoto(id, width, height);
        Log.d("Getting Photo", "Call");
        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                Log.d("Getting Photos", response.code() + " " + response.message());
                int statusCode = response.code();
                if(statusCode == 200) {
                    Photo photo = response.body();
                    listener.onComplete(photo);
                }
                else if(statusCode == 401) {
                    Log.d("Unsplash", "Unauthorized, Check your client Id");
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                // Log error here since request failed
                Log.d("Getting Photos", "Failure");
                listener.onError(t.getMessage());
            }
        });
    }

    public interface OnPhotosLoadedListener {
        public void onComplete(List<Photo> photos);

        public void onError(String error);
    }

    public interface OnPhotoLoadedListener {
        public void onComplete(Photo photo);

        public void onError(String error);
    }

    public interface OnDownloadLinkListener {

        public void onComplete(String downloadLink);

        public void onError(String error);
    }

}
