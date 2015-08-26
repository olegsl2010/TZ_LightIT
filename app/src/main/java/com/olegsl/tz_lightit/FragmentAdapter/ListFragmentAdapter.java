package com.olegsl.tz_lightit.FragmentAdapter;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.olegsl.tz_lightit.R;

/**
 * Created by apple on 21.08.15.
 */
public class ListFragmentAdapter extends Fragment {

    View rootView;
    FragmentTransaction fragManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.list_fragment_adapter, container, false);


        fragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
//        fragManager.replace(R.id.dinamicFragment, new ListProduct(), "ListProduct");
        fragManager.commit();



        return rootView;
    }

}
