package com.olegsl.tz_lightit.StartMenu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.olegsl.tz_lightit.ListProduct.ListProduct;
import com.olegsl.tz_lightit.R;


public class StartFragment extends Fragment implements View.OnClickListener {

    View rootView;
    Button signUpButton;
    Button viewProducts;
    Button logInButton;
    protected EditText login, password;
    FragmentTransaction fragManager;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.login_frame, container, false);


        signUpButton = (Button) rootView.findViewById(R.id.signUpButton);
        viewProducts = (Button) rootView.findViewById(R.id.viewProducts);
        logInButton = (Button) rootView.findViewById(R.id.logInButton);
        login = (EditText) rootView.findViewById(R.id.login);
        password = (EditText) rootView.findViewById(R.id.password);


        signUpButton.setOnClickListener(this);
        viewProducts.setOnClickListener(this);
        logInButton.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View v) {
        fragManager = getFragmentManager().beginTransaction();


        switch (v.getId()) {
            case R.id.signUpButton:
//
//                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
//                fragManager.replace(R.id.container, new ForgotPassword());

                break;

            case R.id.viewProducts:
//
                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                fragManager.replace(R.id.container, new ListProduct());
                fragManager.addToBackStack(null);
                break;

            case R.id.logInButton:

                final String getLogin = login.getText().toString();
                final String getPassword = password.getText().toString();
                ValidatorLogIn logIn = new ValidatorLogIn();

                if (logIn.isValidEmail(getLogin) && logIn.isValidPassword(getPassword)== true) {
                    Toast toast = new Toast(rootView.getContext());
                    toast.makeText(rootView.getContext(),"Login and password is valid",Toast.LENGTH_LONG).show();
                }

                else
                {
                    if(logIn.isValidEmail(getLogin)!=true){
                        login.setError(getString(R.string.login_error));}
                    if(logIn.isValidPassword(getPassword)!=true){
                        password.setError(getString(R.string.password_error));}
                }

                break;

        }
        fragManager.commit();
    }
}