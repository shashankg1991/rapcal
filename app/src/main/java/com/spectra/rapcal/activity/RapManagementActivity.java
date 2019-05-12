package com.spectra.rapcal.activity;

import android.os.Bundle;

import com.spectra.rapcal.R;
import com.spectra.rapcal.fragment.AddEditRapFragment;
import com.spectra.rapcal.fragment.LoginFragment;
import com.spectra.rapcal.fragment.ViewRapsFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class RapManagementActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rap_management);

        fragmentManager = getSupportFragmentManager();
        if (null != findViewById(R.id.activity_rap_management_fragment_container)) {
            if (null != savedInstanceState) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.activity_rap_management_fragment_container, new ViewRapsFragment()).commit();
        }
    }

}
