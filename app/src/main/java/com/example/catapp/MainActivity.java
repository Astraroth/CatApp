package com.example.catapp;

import com.example.catapp.model.CatBreed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar loader;
    private MainController controller;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        loader = findViewById(R.id.progressBar);

        controller = new MainController(this);
        controller.onCreate();

    }

    public void showLoader(){
        loader.setVisibility(View.VISIBLE);
    }
    public void hideLoader(){
        loader.setVisibility(View.GONE);
    }

    public void showList(List<CatBreed> list){

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // define an adapter
        mAdapter = new RecyclerViewAdapter(list,

                new OnItemClickListener() {
                    @Override
                    public void onItemClick(CatBreed item) {

                        Toast.makeText(getApplicationContext(), item.getName(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("detail_description",  item.getDescription());
                        intent.putExtra("detail_temperament",  item.getTemperament());
                        getApplicationContext().startActivity(intent);
                    }
                });
        recyclerView.setAdapter(mAdapter);

    }

}