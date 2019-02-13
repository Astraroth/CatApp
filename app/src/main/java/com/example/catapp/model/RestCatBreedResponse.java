package com.example.catapp.model;

import java.util.List;

public class RestCatBreedResponse { private Integer count; //classe inutile car reponse json direct un tableau ?

    private List<CatBreed> results;

    public List<CatBreed> getResults() {
        return results;
    }

    public void setResults(List<CatBreed> results) {
        this.results = results;
    }
}
