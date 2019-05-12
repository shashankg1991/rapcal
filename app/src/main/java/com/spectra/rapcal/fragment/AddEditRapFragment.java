package com.spectra.rapcal.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.RapManagementActivity;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.enums.Color;
import com.spectra.rapcal.enums.LowerLimit;
import com.spectra.rapcal.enums.Purity;
import com.spectra.rapcal.enums.Shape;
import com.spectra.rapcal.enums.UpperLimit;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.service.RapService;
import com.spectra.rapcal.util.SpinnerUtil;
import com.spectra.rapcal.util.StringUtil;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditRapFragment extends Fragment implements View.OnClickListener {
    Spinner spinnerColor, spinnerPurity, spinnerShape, spinnerLowerLimit, spinnerUpperLimit;
    EditText editTextRapValue;
    Button buttonSave;
    Integer id;

    public AddEditRapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_edit_rap, container, false);


        spinnerColor = view.findViewById(R.id.frag_add_edit_rap_spinner_color);
        ArrayAdapter<String> colorArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, Color.values());
        spinnerColor.setSelection(0);
        spinnerColor.setAdapter(colorArrayAdapter);

        spinnerPurity = view.findViewById(R.id.frag_add_edit_rap_spinner_purity);
        ArrayAdapter<String> purityArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, Purity.values());
        spinnerPurity.setSelection(0);
        spinnerPurity.setAdapter(purityArrayAdapter);

        spinnerShape = view.findViewById(R.id.frag_add_edit_rap_spinner_shape);
        ArrayAdapter<String> shapeArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, Shape.values());
        spinnerShape.setSelection(0);
        spinnerShape.setAdapter(shapeArrayAdapter);

        spinnerLowerLimit = view.findViewById(R.id.frag_add_edit_rap_spinner_lowerLimit);
        ArrayAdapter<String> lowerLimitArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, LowerLimit.values());
        spinnerLowerLimit.setSelection(0);
        spinnerLowerLimit.setAdapter(lowerLimitArrayAdapter);

        spinnerUpperLimit = view.findViewById(R.id.frag_add_edit_rap_spinner_upperLimit);
        ArrayAdapter<String> upperLimitArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, UpperLimit.values());
        spinnerUpperLimit.setSelection(0);
        spinnerUpperLimit.setAdapter(upperLimitArrayAdapter);

        editTextRapValue = view.findViewById(R.id.frag_add_edit_rap_editText_rapValue);

        id = getArguments().getInt(RapCalConstants.ID);
        if (null != id && -1 != id) {
            Rap savedRap = RapService.getInstance().getRapById(id);
            if (null != savedRap) {
                SpinnerUtil.setSpinnerOptionValue(spinnerColor,savedRap.getColor());
                SpinnerUtil.setSpinnerOptionValue(spinnerPurity,savedRap.getPurity());
                SpinnerUtil.setSpinnerOptionValue(spinnerShape,savedRap.getShape());
                editTextRapValue.setText(savedRap.getValue().toString());
            }
        }


        buttonSave = view.findViewById(R.id.frag_add_edit_rap_button_save);
        buttonSave.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frag_add_edit_rap_button_save:
                String rapValue = editTextRapValue.getText().toString();
                if (StringUtil.isEmpty(rapValue)) {
                    Toast.makeText(getActivity(), "Please enter Rap value.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    String shape = spinnerShape.getSelectedItem().toString();
                    String color = spinnerColor.getSelectedItem().toString();
                    String purity = spinnerPurity.getSelectedItem().toString();
                    String lowerLimit = spinnerLowerLimit.getSelectedItem().toString();
                    String upperLimit = spinnerUpperLimit.getSelectedItem().toString();
                    if (id == -1) {
                        RapService.getInstance().addRap(shape, color, purity, lowerLimit, upperLimit, rapValue);
                    } else {
                        RapService.getInstance().updateRap(id, shape, color, purity, lowerLimit, upperLimit, rapValue);
                    }
                    spinnerShape.setSelection(0);
                    spinnerColor.setSelection(0);
                    spinnerPurity.setSelection(0);
                    spinnerLowerLimit.setSelection(0);
                    spinnerUpperLimit.setSelection(0);
                    editTextRapValue.setText("");
                    RapManagementActivity.fragmentManager
                            .beginTransaction()
                            .replace(R.id.activity_rap_management_fragment_container, new ViewRapsFragment())
                            .commit();

                }
                break;
        }

    }
}
