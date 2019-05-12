package com.spectra.rapcal.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.spectra.rapcal.R;
import com.spectra.rapcal.activity.LoginActivity;
import com.spectra.rapcal.activity.OptionsActivity;
import com.spectra.rapcal.persistence.service.UserService;
import com.spectra.rapcal.util.StringUtil;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private TextView textViewRegister;
    private EditText editTextUser, editTextPassword, editTextDollarRate;
    private Button btnLogin;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        textViewRegister = view.findViewById(R.id.frag_login_textView_register);
        editTextUser = view.findViewById(R.id.frag_login_editText_username);
        editTextPassword = view.findViewById(R.id.frag_login_editText_password);
        editTextDollarRate = view.findViewById(R.id.frag_login_editText_dollarRate);
        btnLogin = view.findViewById(R.id.frag_login_button_login);

        //Register listeners
        textViewRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frag_login_textView_register:
                LoginActivity.fragmentManager
                        .beginTransaction()
                        .replace(R.id.activity_login_fragment_container, new RegisterUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.frag_login_button_login:
                String username = null != editTextUser.getText() ? editTextUser.getText().toString() : null;
                String password = null != editTextPassword.getText() ? editTextPassword.getText().toString() : null;
                String dollarRate = null != editTextDollarRate.getText() ? editTextDollarRate.getText().toString() : null;
                if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password) || StringUtil.isEmpty(dollarRate)) {
                    Toast.makeText(getActivity(), "Please enter all the details.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (UserService.getInstance().login(username, password)) {
                    Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
                    LoginActivity.dollarRate = StringUtil.getDoubleValue(dollarRate);
                    Intent intent = new Intent(getActivity(), OptionsActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getActivity(), "Invalid credentials!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
