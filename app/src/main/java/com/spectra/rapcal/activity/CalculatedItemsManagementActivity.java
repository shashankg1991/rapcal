package com.spectra.rapcal.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.View;

import com.spectra.rapcal.R;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.fragment.CalculateItemPriceFragment;
import com.spectra.rapcal.fragment.ViewCalculateItemsFragment;

public class CalculatedItemsManagementActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_items_management);
        fragmentManager = getSupportFragmentManager();
        if (null != findViewById(R.id.activity_stones_management_fragment_container)) {
            if (null != savedInstanceState) {
                return;
            }

            ViewCalculateItemsFragment viewCalculateItemsFragment = new ViewCalculateItemsFragment();
            fragmentManager.beginTransaction().add(R.id.activity_stones_management_fragment_container, viewCalculateItemsFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }

}
