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

public class ItemHomeAdapter extends RecyclerView.Adapter<ItemHomeAdapter.ViewHolder> {
    Context activityContext;
    List<Item> itemList;

    public ItemHomeAdapter(List<Item> inputItem){
        itemList = inputItem;
    }

    @NonNull
    @Override
    public ItemHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activityContext);
        View view = inflater.inflate(R.layout.item_model, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHomeAdapter.ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.watchName.setText(item.getName());
        holder.watchPrice.setText(String.format("Rp %,d", (int) item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return Math.min(itemList.size(), 7);
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
