package com.example.proyekmpevan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {

    RecyclerView recyclerView;
    ItemProductAdapter itemAdapter;
    List<ItemModel> watchList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        recyclerView = view.findViewById(R.id.productRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        // Divider
        DividerItemDecoration horizontalDivider = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(horizontalDivider);
        DividerItemDecoration verticalDivider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(verticalDivider);

        watchList = getWatchList();
        itemAdapter = new ItemProductAdapter(watchList);
        recyclerView.setAdapter(itemAdapter);


        return view;
    }

    // Sample data, nanti hapus kalau sudah bikin database
    private List<ItemModel> getWatchList() {
        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Alexandre Christie Chronograph AC 6", 1500000.0));
        list.add(new ItemModel("Spinnaker Fleuss SP-5055-06", 2315000.0));
        list.add(new ItemModel("Timex Weekender TW2R42500", 215000.0));
        list.add(new ItemModel("Rolex Submariner", 150000000));
        list.add(new ItemModel("Rolex GMT Master", 200000000));
        list.add(new ItemModel("Seiko 5 Sport ", 10000000));
        list.add(new ItemModel("Alexandre Christie Chronograph AC 6", 1500000.0));
        list.add(new ItemModel("Spinnaker Fleuss SP-5055-06", 2315000.0));
        list.add(new ItemModel("Timex Weekender TW2R42500", 215000.0));
        return list;
    }
}