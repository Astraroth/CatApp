package com.example.catapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.catapp.model.CatBreed;

import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import android.graphics.Bitmap;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<CatBreed> values;
    private final OnItemClickListener listener;
    private Context context;

    public RecyclerViewAdapter(List<CatBreed> myDataset, OnItemClickListener listener) { //constructor
        values = myDataset;
        this.listener = listener;
    }

    public void add(int position, CatBreed item) {
        values.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        return values.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        CircleImageView circleImageView;
        public TextView txtName;
        public TextView txtName2;
        public RelativeLayout parent_layout;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtName = (TextView) v.findViewById(R.id.firstLine);
            txtName2 = (TextView) v.findViewById(R.id.secondLine);
            parent_layout = (RelativeLayout) v.findViewById(R.id.parent_layout);
        }

    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //get element from your dataset at this position
        //replace the contents of the view with that element
        final CatBreed selectedCat = values.get(position);
        final String name = selectedCat.getName();
        holder.txtName.setText(name);

        final String origin = selectedCat.getOrigin();
        holder.txtName2.setText(origin);

        Log.d("ON BIND", "called");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(selectedCat);

            }
        });
    }





}

