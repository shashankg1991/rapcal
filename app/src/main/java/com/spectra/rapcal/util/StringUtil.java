package com.spectra.rapcal.util;

import android.widget.EditText;
import android.widget.TextView;

public class StringUtil {
    public static boolean isEmpty(String value) {
        if (null == value) {
            return true;

        }
        if (value.length() == 0) {
            return true;
        }
        return false;
    }

    public static String getValue(EditText editText) {
        return null != editText.getText() ? editText.getText().toString() : null;
    }

    public static String getValue(TextView editText) {
        return null != editText.getText() ? editText.getText().toString() : null;
    }

    public static Double getDoubleValue(EditText editText) {
        try {
            return Double.valueOf(editText.getText().toString());
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static Double getDoubleValue(TextView textView) {
        try {
            return Double.valueOf(textView.getText().toString());
        } catch (Exception e) {
            return 0.0d;
        }
    }
}
