package com.spectra.rapcal.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spectra.rapcal.R;
import com.spectra.rapcal.adapter.StoneRecylerViewAdapter;
import com.spectra.rapcal.persistence.entity.Stone;
import com.spectra.rapcal.persistence.service.StoneService;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewCalculateItemsFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Stone> savedStones;

    public ViewCalculateItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_calculated_items, container, false);
        savedStones = StoneService.getInstance().getAllStones();

        recyclerView = view.findViewById(R.id.frag_view_stones_recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        StoneRecylerViewAdapter stoneRecylerViewAdapter = new StoneRecylerViewAdapter(savedStones, getActivity());
        recyclerView.setAdapter(stoneRecylerViewAdapter);

        return view;
    }
}
