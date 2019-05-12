package com.spectra.rapcal.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.LoginActivity;
import com.spectra.rapcal.constants.RapCalConstants;
import com.spectra.rapcal.persistence.service.UserService;
import com.spectra.rapcal.util.HashUtil;
import com.spectra.rapcal.util.StringUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterUserFragment extends Fragment implements View.OnClickListener {

    private EditText editTextUser, editTextPassword, editTextKey;
    private Button btnRegister;

    public RegisterUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_user, container, false);
        btnRegister = view.findViewById(R.id.frag_register_button_register);
        editTextUser = view.findViewById(R.id.frag_register_editText_username);
        editTextPassword = view.findViewById(R.id.frag_register_editText_password);
        editTextKey = view.findViewById(R.id.frag_register_editText_key);

        //Register listeners
        btnRegister.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frag_register_button_register:
                String username = StringUtil.getValue(editTextUser);
                String password = StringUtil.getValue(editTextPassword);
                String key = StringUtil.getValue(editTextKey);
                if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password) || StringUtil.isEmpty(key)) {
                    Toast.makeText(getActivity(), "Please enter all the details.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!HashUtil.md5(key).equals(RapCalConstants.KEY_HASH)) {
                    Toast.makeText(getActivity(), "Invalid key.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    UserService.getInstance().addUser(username, password);
                    resetFragment();
                    Toast.makeText(getActivity(), "User registered....", Toast.LENGTH_SHORT).show();

                    //Go to login fragment
                    LoginActivity.fragmentManager
                            .beginTransaction()
                            .replace(R.id.activity_login_fragment_container, new LoginFragment())
                            .commit();
                }

        }
    }

    private void resetFragment() {
        editTextUser.setText("");
        editTextPassword.setText("");
        editTextKey.setText("");
    }
}
