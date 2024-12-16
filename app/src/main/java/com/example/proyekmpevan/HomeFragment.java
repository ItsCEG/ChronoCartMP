package com.example.proyekmpevan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    ImageSlider imageSlider;
    ArrayList<SlideModel> slideModels;
    List<ItemModel> itemList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.homeImageIS);
        slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.image1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image4, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        RecyclerView rv = view.findViewById(R.id.homeRecyclerRV);
        rv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));

        // dummy item, harus pakai database. Nanti ini dihapus
        itemList = new ArrayList<>();
        itemList.add(new ItemModel("Casio", "Rp 1.250.000"));
        itemList.add(new ItemModel("Rolex", "Rp 10.000.000"));
        itemList.add(new ItemModel("Seiko", "Rp 525.000"));
        itemList.add(new ItemModel("Timex", "Rp 15.000.000"));
        itemList.add(new ItemModel("Omega", "Rp 250.000"));

        ItemAdapter adapter = new ItemAdapter(itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(adapter);
        return view;
    }
}