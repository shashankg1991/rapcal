package com.spectra.rapcal.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.CalculatedItemsManagementActivity;
import com.spectra.rapcal.activity.OnlineReportActivity;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.enums.CertificateType;
import com.spectra.rapcal.enums.Color;
import com.spectra.rapcal.enums.Purity;
import com.spectra.rapcal.enums.Shape;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.entity.Stone;
import com.spectra.rapcal.persistence.service.RapService;
import com.spectra.rapcal.persistence.service.StoneService;
import com.spectra.rapcal.util.SpinnerUtil;
import com.spectra.rapcal.util.StringUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculateItemPriceFragment extends Fragment implements View.OnClickListener {

    Spinner spinnerColor, spinnerPurity, spinnerShape, spinnerCertificateType;
    EditText editTextParty, editTextDiscount, editTextWeight, editTextComments, editTextCertificate;
    TextView textViewId, textViewValue, textViewRapValue;
    Button buttonCalculate, buttonSave;
    ImageButton imageButtonViewReport;
    Integer id;

    public CalculateItemPriceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculate_item_price, container, false);

        spinnerColor = view.findViewById(R.id.frag_calc_item_price_spinner_color);
        ArrayAdapter<String> colorArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, Color.values());
        spinnerColor.setSelection(0);
        spinnerColor.setAdapter(colorArrayAdapter);

        spinnerPurity = view.findViewById(R.id.frag_calc_item_price_spinner_purity);
        ArrayAdapter<String> purityArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, Purity.values());
        spinnerPurity.setSelection(0);
        spinnerPurity.setAdapter(purityArrayAdapter);

        spinnerShape = view.findViewById(R.id.frag_calc_item_price_spinner_shape);
        ArrayAdapter<String> shapeArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, Shape.values());
        spinnerShape.setSelection(0);
        spinnerShape.setAdapter(shapeArrayAdapter);

        spinnerCertificateType = view.findViewById(R.id.frag_calc_item_price_spinner_certificateType);
        ArrayAdapter<String> certificateTypeArrayAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, CertificateType.values());
        spinnerCertificateType.setSelection(0);
        spinnerCertificateType.setAdapter(certificateTypeArrayAdapter);

        editTextDiscount = view.findViewById(R.id.frag_calc_item_price_editText_discount);
        editTextWeight = view.findViewById(R.id.frag_calc_item_price_editText_weight);
        editTextCertificate = view.findViewById(R.id.frag_calc_item_price_editText_certificate);
        editTextParty = view.findViewById(R.id.frag_calc_item_price_editText_party);
        editTextComments = view.findViewById(R.id.frag_calc_item_price_editText_comments);
        textViewId = view.findViewById(R.id.frag_calc_item_price_textView_id);
        textViewValue = view.findViewById(R.id.frag_calc_item_price_textView_value);
        textViewRapValue = view.findViewById(R.id.frag_calc_item_price_textView_rap_value);

        id = getArguments().getInt(RapCalConstants.ID);
        if (null != id && -1 != id) {
            Stone savedStone = StoneService.getInstance().getStoneById(id);
            if (null != savedStone) {
                SpinnerUtil.setSpinnerOptionValue(spinnerColor, savedStone.getColor());
                SpinnerUtil.setSpinnerOptionValue(spinnerPurity, savedStone.getPurity());
                SpinnerUtil.setSpinnerOptionValue(spinnerShape, savedStone.getShape());
                SpinnerUtil.setSpinnerOptionValue(spinnerCertificateType, savedStone.getCertificateType());
                textViewId.setText(savedStone.getId().toString());
                editTextDiscount.setText(savedStone.getDiscountPercentage().toString());
                editTextWeight.setText(savedStone.getWeight().toString());
                editTextCertificate.setText(savedStone.getReportId());
                editTextParty.setText(savedStone.getParty());
                editTextComments.setText(savedStone.getComments());
                textViewValue.setText(savedStone.getValue().toString());
                Rap rap = RapService.getInstance().getRap(savedStone.getShape(), savedStone.getColor(), savedStone.getPurity(), savedStone.getWeight());
                if (null != rap) {
                    textViewRapValue.setText(rap.getValue().toString());
                }
            }
        }

        imageButtonViewReport = view.findViewById(R.id.frag_calc_item_price_button_viewRap);
        buttonCalculate = view.findViewById(R.id.frag_calc_item_price_button_calculate);
        buttonSave = view.findViewById(R.id.frag_calc_item_price_button_save);
        buttonCalculate.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
        imageButtonViewReport.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String shape = spinnerShape.getSelectedItem().toString();
        String color = spinnerColor.getSelectedItem().toString();
        String purity = spinnerPurity.getSelectedItem().toString();
        String certificateType = spinnerCertificateType.getSelectedItem().toString();
        String party = StringUtil.getValue(editTextParty);
        String discount = StringUtil.getValue(editTextDiscount);
        String certificate = StringUtil.getValue(editTextCertificate);
        String comments = StringUtil.getValue(editTextComments);
        String weight = StringUtil.getValue(editTextWeight);
        switch (view.getId()) {
            case R.id.frag_calc_item_price_button_save:
                if (StringUtil.isEmpty(weight)) {
                    Toast.makeText(getActivity(), "Please enter weight value.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (id == -1) {
                        StoneService.getInstance().addStone(shape, color, purity, weight, discount, certificateType, party, certificate, comments);
                    } else {
                        StoneService.getInstance().updateStone(id, shape, color, purity, weight, discount, certificateType, party, certificate, comments);
                    }
                    spinnerShape.setSelection(0);
                    spinnerColor.setSelection(0);
                    spinnerPurity.setSelection(0);
                    spinnerCertificateType.setSelection(0);
                    editTextParty.setText("");
                    editTextDiscount.setText("");
                    editTextCertificate.setText("");
                    editTextComments.setText("");
                    textViewRapValue.setText("-");
                    textViewId.setText("-");
                    Intent intentCalculatedItemsManagementActivity = new Intent(getActivity(), CalculatedItemsManagementActivity.class);
                    getActivity().startActivity(intentCalculatedItemsManagementActivity);
                    getActivity().finish();
                }
                break;
            case R.id.frag_calc_item_price_button_calculate:
                Rap rap = RapService.getInstance().getRap(shape, color, purity, Double.valueOf(weight));
                Double value = StoneService.getInstance().calculate(shape, color, purity, weight, discount);
                if (null != rap) {
                    textViewRapValue.setText(rap.getValue().toString());
                    textViewValue.setText(value.toString());
                } else {
                    Toast.makeText(getActivity(), "Rap not found!!", Toast.LENGTH_SHORT).show();
                }

            case R.id.frag_calc_item_price_button_viewRap:
                if (StringUtil.isEmpty(editTextCertificate.getText().toString())) {
                    Toast.makeText(getActivity(), "Please enter reprot number!!", Toast.LENGTH_SHORT).show();
                }
                Intent intentOnlineReportActivity = new Intent(getActivity(), OnlineReportActivity.class);
                intentOnlineReportActivity.putExtra(RapCalConstants.REPORT_TYPE,spinnerCertificateType.getSelectedItem().toString());
                intentOnlineReportActivity.putExtra(RapCalConstants.REPORT_ID,editTextCertificate.getText().toString());
                getActivity().startActivity(intentOnlineReportActivity);
        }

    }
}
