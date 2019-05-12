package com.spectra.rapcal.util;

import android.widget.Spinner;

public class SpinnerUtil {
    public static void setSpinnerOptionValue(Spinner spinner, Object value) {
        for (int i = 0, count = spinner.getCount(); i < count; i++) {
            Object spinnerValue = spinner.getItemAtPosition(i);
            if (spinnerValue.toString().equals(value)) {
                spinner.setSelection(i, true);
                return;
            }
        }
    }
}
