package com.akmthecoder.foodiemart.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akmthecoder.foodiemart.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Viewholder> {
    private Context context;
    public ItemAdapter(android.content.Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class Viewholder extends RecyclerView.ViewHolder{
        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
