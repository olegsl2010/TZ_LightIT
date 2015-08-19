package com.olegsl.tz_lightit;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.olegsl.tz_lightit.StartMenu.StartFragment;


public class MainActivity extends Activity {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = new StartFragment();
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
           getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone)
                    .add(R.id.container, fragment)
                    .commit();
        }

    }




}
