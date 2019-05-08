package com.spectra.rapcal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.spectra.rapcal.constants.RapCalConstants;

import static com.spectra.rapcal.constants.RapCalConstants.DOLLAR_RATE;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        EditText dollarRateEditText = findViewById(R.id.editText_dollarRate);
        Double dollarRate = Double.valueOf(dollarRateEditText.getText().toString());
        Intent intent = new Intent(this, OptionsActivity.class);
        intent.putExtra(DOLLAR_RATE, dollarRate);
        startActivity(intent);
    }
}
