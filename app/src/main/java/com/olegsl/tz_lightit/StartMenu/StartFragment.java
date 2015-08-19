package com.olegsl.tz_lightit.StartMenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olegsl.tz_lightit.R;


public class StartFragment extends Fragment {

    View rootView;




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.login_frame, container, false);

        return rootView;
    }




}
