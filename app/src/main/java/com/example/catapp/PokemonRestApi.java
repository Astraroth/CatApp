package com.example.catapp;

import com.example.catapp.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonRestApi  {

    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();
}
