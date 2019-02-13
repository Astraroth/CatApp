package com.example.catapp;

import android.util.Log;

import com.example.catapp.model.CatBreed;
import com.example.catapp.model.Pokemon;
import com.example.catapp.model.RestCatBreedResponse;
import com.example.catapp.model.RestPokemonResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
public class MainController {

    private final MainActivity mainActivity;

    private static MainController instance = null;

    //Exemple Singleton
    public static MainController getInstance(MainActivity mainActivity){
        if(instance == null){
            instance = new MainController(mainActivity);
        }
        return instance;

    }
    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void onCreate() {
        mainActivity.showLoader();

        //La création de ces objets, ce serait bien de ne pas
        // les réinstancier plusieurs fois.
        //--> Voir le cours de Génie Logiciel : Singleton()
        //Pour ceux qui veulent aller plus loin -> Injection de Dépendances
        //On crée un objet Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")  //https://api.thecatapi.com/v1/
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //On crée notre interface PokemonRestApi
        PokemonRestApi pokemonRestApi = retrofit.create(PokemonRestApi.class);

        //On récupére un objet call.
        Call<RestPokemonResponse> call = pokemonRestApi.getListPokemon();

        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {

                RestPokemonResponse restPokemonResponse = response.body();
                List<Pokemon> listPokemon = restPokemonResponse.getResults();
                mainActivity.showList(listPokemon);
                mainActivity.hideLoader();
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }

    public void onItemClicked(Pokemon itemClicked){

    }
}
*/

public class MainController {

    private final MainActivity mainActivity;

    private static MainController instance = null;

    //Exemple Singleton
    public static MainController getInstance(MainActivity mainActivity){
        if(instance == null){
            instance = new MainController(mainActivity);
        }
        return instance;

    }
    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void onCreate() {
        mainActivity.showLoader();

        //La création de ces objets, ce serait bien de ne pas
        // les réinstancier plusieurs fois.
        //--> Voir le cours de Génie Logiciel : Singleton()
        //Pour ceux qui veulent aller plus loin -> Injection de Dépendances
        //On crée un objet Gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //On crée notre interface PokemonRestApi
        CatRestApi catRestApi = retrofit.create(CatRestApi.class);

        //On récupére un objet call.
        //Call<RestCatBreedResponse> call = catRestApi.getListCatBreeds();
        Call<List<CatBreed>> call = catRestApi.getListCatBreeds();

        call.enqueue(new Callback<List<CatBreed>>() {
            @Override
            public void onResponse(Call<List<CatBreed>> call, Response<List<CatBreed>> response) {

                List<CatBreed> listCatBreed = response.body();

                mainActivity.showList(listCatBreed);
                mainActivity.hideLoader();
            }

            @Override
            public void onFailure(Call<List<CatBreed>> call, Throwable t) {
                Log.d("Erreur", "API ERROR");
            }
        });
    }

    //public void onItemClicked(Pokemon itemClicked){

    //}
}

