package com.example.proyekmpevan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    Context activityContext;
    List<ItemModel> itemList;

    public ItemAdapter(List<ItemModel> inputItem){
        itemList = inputItem;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activityContext);
        View view = inflater.inflate(R.layout.item_model, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        String name = itemList.get(position).getName();
        String price = itemList.get(position).getPrice();

        holder.watchName.setText(name);
        holder.watchPrice.setText(price);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView watchImage;
        TextView watchName, watchPrice;
        ConstraintLayout itemContainer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            watchImage = itemView.findViewById(R.id.watchImage);
            watchName = itemView.findViewById(R.id.watchName);
            watchPrice = itemView.findViewById(R.id.watchPrice);
            itemContainer = itemView.findViewById(R.id.itemContainer);
        }
    }
}
