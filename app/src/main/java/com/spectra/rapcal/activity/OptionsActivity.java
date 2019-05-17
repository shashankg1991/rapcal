package com.spectra.rapcal.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.spectra.rapcal.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewDollarRate;
    Button buttonManageRap, buttonManageCalculated, buttonCalculate, buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        textViewDollarRate = findViewById(R.id.activity_options_textView_dollarRate);
        textViewDollarRate.setText("Dollar Rate : " + LoginActivity.dollarRate);
        buttonManageRap = findViewById(R.id.activity_options_button_manageRap);
        buttonManageCalculated = findViewById(R.id.activity_options_button_manageCalculated);
        buttonCalculate = findViewById(R.id.activity_options_button_calculate);
        buttonExit = findViewById(R.id.activity_options_button_exit);
        buttonManageRap.setOnClickListener(this);
        buttonManageCalculated.setOnClickListener(this);
        buttonCalculate.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.activity_options_button_manageRap:
                intent = new Intent(this, RapManagementActivity.class);
                if (null != intent) {
                    startActivity(intent);
                }
                break;
            case R.id.activity_options_button_calculate:
                intent = new Intent(this, RapCalculationActivity.class);
                if (null != intent) {
                    startActivity(intent);
                }
                break;
            case R.id.activity_options_button_manageCalculated:
                intent = new Intent(this, CalculatedItemsManagementActivity.class);
                if (null != intent) {
                    startActivity(intent);
                }
                break;
            case R.id.activity_options_button_exit:
                final AlertDialog.Builder builder = new AlertDialog.Builder(OptionsActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Do you want to exit ??");
                builder.setPositiveButton("Yes. Exit now!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        moveTaskToBack(true);
                    }
                });
                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        return;
    }
}
