package com.example.catapp;

import com.example.catapp.model.CatBreed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CatRestApi {

    @Headers("x-api-key: " + "c445322a-430a-4c33-ac6c-85c0a459fs97")
    @GET("breeds")
    Call<List<CatBreed>> getListCatBreeds();
}
