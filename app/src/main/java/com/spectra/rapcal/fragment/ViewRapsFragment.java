package com.spectra.rapcal.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.CalculatedItemsManagementActivity;
import com.spectra.rapcal.activity.LoginActivity;
import com.spectra.rapcal.activity.OptionsActivity;
import com.spectra.rapcal.activity.RapManagementActivity;
import com.spectra.rapcal.adapter.RapRecylerViewAdapter;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.service.RapService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRapsFragment extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button buttonAddRap, buttonUpdateRaps;
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
        buttonUpdateRaps = view.findViewById(R.id.frag_view_raps_button_updateraps);
        buttonAddRap.setOnClickListener(this);
        buttonUpdateRaps.setOnClickListener(this);
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
            case R.id.frag_view_raps_button_updateraps:
                RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, RapCalConstants.RAPS_UPDATE_URL, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    Gson gson = new Gson();
                                    ArrayList<Rap> rapsList = new ArrayList<>();
                                    JSONArray raps = response.getJSONArray(RapCalConstants.JSON_RAPS);
                                    for (int i = 0; i < raps.length(); i++) {
                                        rapsList.add(gson.fromJson(raps.getString(i), Rap.class));
                                    }
                                    RapService.getInstance().updateRaps(rapsList);
                                    Intent intentOptionsActivity = new Intent(getActivity(), OptionsActivity.class);
                                    getActivity().startActivity(intentOptionsActivity);
                                    getActivity().finish();
                                } catch (JSONException je) {
                                    je.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        });
                requestQueue.add(jsonObjectRequest);
        }
    }
}
