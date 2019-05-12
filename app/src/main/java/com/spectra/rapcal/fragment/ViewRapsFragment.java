package com.spectra.rapcal.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.LoginActivity;
import com.spectra.rapcal.activity.RapManagementActivity;
import com.spectra.rapcal.adapter.RapRecylerViewAdapter;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.service.RapService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRapsFragment extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button buttonAddRap;
    List<Rap> savedRaps;

    public ViewRapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_raps, container, false);
        savedRaps = RapService.getInstance().getAllRaps();

        recyclerView = view.findViewById(R.id.frag_view_raps_recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RapRecylerViewAdapter rapRecylerViewAdapter = new RapRecylerViewAdapter(savedRaps);
        recyclerView.setAdapter(rapRecylerViewAdapter);

        buttonAddRap = view.findViewById(R.id.frag_view_raps_button_addrap);
        buttonAddRap.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frag_view_raps_button_addrap:
                Fragment addEditRapFragment = new AddEditRapFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(RapCalConstants.ID, -1);
                addEditRapFragment.setArguments(bundle);
                RapManagementActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.activity_rap_management_fragment_container, addEditRapFragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
