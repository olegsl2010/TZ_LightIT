package com.olegsl.tz_lightit.StartMenu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.olegsl.tz_lightit.ListProduct.ListProduct;
import com.olegsl.tz_lightit.R;


public class StartFragment extends Fragment implements View.OnClickListener {

    View rootView;
    Button signUpButton;
    Button viewProducts;
    Button logInButton;
    FragmentTransaction fragManager;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.login_frame, container, false);


        signUpButton = (Button) rootView.findViewById(R.id.signUpButton);
        viewProducts = (Button) rootView.findViewById(R.id.viewProducts);
        logInButton = (Button) rootView.findViewById(R.id.logInButton);


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


                break;

            case R.id.logInButton:
//
//                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
//                fragManager.replace(R.id.container, new ForgotPassword());


                break;

        }
        fragManager.commit();
    }
}