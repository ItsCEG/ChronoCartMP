package com.example.proyekmpevan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemProductAdapter extends RecyclerView.Adapter<ItemProductAdapter.ViewHolder> {
    Context activityContext;
    List<Item> itemList;

    public ItemProductAdapter(List<Item> inputItem){
        itemList = inputItem;
    }

    @NonNull
    @Override
    public ItemProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activityContext);
        View view = inflater.inflate(R.layout.item_product, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemProductAdapter.ViewHolder holder, int position) {
        String name = itemList.get(position).getName();
        double price = itemList.get(position).getPrice();

        String priceText = String.format("Rp %.0f", price);

        holder.watchName.setText(name);
        holder.watchPrice.setText(priceText);

        holder.productAddBtn.setOnClickListener(v -> {
            // Add logic here for adding to cart
            Toast.makeText(v.getContext(),
                    name + " added to cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView watchImage;
        TextView watchName, watchPrice;
        Button productAddBtn;
        ConstraintLayout itemContainer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            watchImage = itemView.findViewById(R.id.watchImage);
            watchName = itemView.findViewById(R.id.watchName);
            watchPrice = itemView.findViewById(R.id.watchPrice);
            productAddBtn = itemView.findViewById(R.id.btnAddToCart);
            itemContainer = itemView.findViewById(R.id.itemContainer);
        }
    }
}
