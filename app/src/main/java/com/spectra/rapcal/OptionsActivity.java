package com.spectra.rapcal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.spectra.rapcal.constants.RapCalConstants.DOLLAR_RATE;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Intent intent = getIntent();
        Double dollarRate = intent.getDoubleExtra(DOLLAR_RATE, 70.0d);
        TextView textView = findViewById(R.id.textView_dollarRate);
        textView.setText("Dollar Rate : " + dollarRate);
    }
}
