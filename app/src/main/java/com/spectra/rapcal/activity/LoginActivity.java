package com.spectra.rapcal.activity;

import android.os.Bundle;

import com.spectra.rapcal.fragment.LoginFragment;
import com.spectra.rapcal.R;
import com.spectra.rapcal.persistence.service.PersistanceService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class LoginActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static Double dollarRate = 70.0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize context dependant services.
        PersistanceService.initialize(getApplicationContext());

        setContentView(R.layout.activity_login);
        fragmentManager = getSupportFragmentManager();
        if (null != findViewById(R.id.activity_login_fragment_container)) {
            if (null != savedInstanceState) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.activity_login_fragment_container, new LoginFragment()).commit();
        }
    }

}
