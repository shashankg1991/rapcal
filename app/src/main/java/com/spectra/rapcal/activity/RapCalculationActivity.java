package com.spectra.rapcal.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.spectra.rapcal.R;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.fragment.CalculateItemPriceFragment;
import com.spectra.rapcal.fragment.ViewRapsFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.View;

public class RapCalculationActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rap_calculation);
        fragmentManager = getSupportFragmentManager();

        Integer stoneId = -1;
        if (null != getIntent() && null != getIntent().getExtras()) {
            stoneId = getIntent().getExtras().getInt(RapCalConstants.ID);
        }

        if (null != findViewById(R.id.activity_rap_calculation_fragment_container)) {
            if (null != savedInstanceState) {
                return;
            }

            CalculateItemPriceFragment calculateItemPriceFragment = new CalculateItemPriceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(RapCalConstants.ID, stoneId);
            calculateItemPriceFragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.activity_rap_calculation_fragment_container, calculateItemPriceFragment).commit();
        }
    }

}
