package com.olegsl.tz_lightit.Data;

import com.olegsl.tz_lightit.Instances.Users;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by apple on 03.09.15.
 */
public class InsertUser extends ArrayList<Users> {

    private ArrayList<Users> listData;
    Users data;
    private static final Random RANDOM = new Random();

    public ArrayList<Users> InsertList() {
        listData = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {

            data = new Users();
            data.setIdUser(i);
            data.setUserName(getUsername(i));

            listData.add(i, data);
        }

        return listData;

    }

    private String getUsername(int i) {
        switch (i) {
            default:
            case 0:
                return "Misha";
            case 1:
                return  "Vasya";
            case 2:
                return  "Vanya";
            case 3:
                return  "Yasha";
            case 4:
                return "Lesya";
        }
    }
}