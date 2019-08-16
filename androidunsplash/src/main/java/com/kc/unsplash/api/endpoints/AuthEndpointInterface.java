package com.kc.unsplash.api.endpoints;

import com.kc.unsplash.models.Stats;
import com.kc.unsplash.models.Token;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface AuthEndpointInterface {

    @POST
    Call<Token> getToken(@Url String url,
                         @Query("client_id") String clientID,
                         @Query("client_secret") String clientSecret,
                         @Query("redirect_uri") String redirectURI,
                         @Query("code") String code,
                         @Query("grant_type") String grantType);
}
