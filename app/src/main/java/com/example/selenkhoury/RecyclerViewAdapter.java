package com.example.selenkhoury;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
    //  private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<FoodTModel> foodTModels;

    public RecyclerViewAdapter(Context context,ArrayList<FoodTModel> foodTModels){
        this.context = context;
        this.foodTModels = foodTModels;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int ViewType){
        // this is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row , parent , false);

        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder,int position){
    // assigning values to the views we created in the recycler_view_row layout file
    // based on the position of the recycler view

        holder.tVName.setText(foodTModels.get(position).getFoodName());
        holder.imageView.setImageResource(foodTModels.get(position).getImage());
    }

    @Override
    public int getItemCount(){
        //the recycler view just wants to know the number of items you want displayed
        return foodTModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the views from our recycler_view_row layout file
        // kind of like in the onCreate method

        ImageView imageView;
        TextView tVName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView0);
            imageView = itemView.findViewById(R.id.imageView1);
            imageView = itemView.findViewById(R.id.imageView2);
            imageView = itemView.findViewById(R.id.imageView3);
            imageView = itemView.findViewById(R.id.imageView4);
            imageView = itemView.findViewById(R.id.imageView5);
            imageView = itemView.findViewById(R.id.imageView6);
            tVName = itemView.findViewById(R.id.textView0);
            tVName = itemView.findViewById(R.id.textView1);
            tVName = itemView.findViewById(R.id.textView2);
            tVName = itemView.findViewById(R.id.textView3);
            tVName = itemView.findViewById(R.id.textView4);
            tVName = itemView.findViewById(R.id.textView5);
            tVName = itemView.findViewById(R.id.textView6);

        }
    }
}
