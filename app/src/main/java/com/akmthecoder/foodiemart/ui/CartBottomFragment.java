package com.akmthecoder.foodiemart.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akmthecoder.foodiemart.R;
import com.akmthecoder.foodiemart.adapter.ItemAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CartBottomFragment extends BottomSheetDialogFragment {
    private RecyclerView slides;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.layout_add_to_cart,container,false);
        slides = view.findViewById(R.id.rv_sides);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ItemAdapter adapter = new ItemAdapter(getContext());
       LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
       layoutManager.setOrientation(RecyclerView.HORIZONTAL);
       slides.setLayoutManager(layoutManager);
       slides.setAdapter(adapter);
    }
}
