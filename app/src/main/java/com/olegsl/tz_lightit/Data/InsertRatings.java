package com.olegsl.tz_lightit.Data;

import com.olegsl.tz_lightit.Instances.Reviews;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by apple on 03.09.15.
 */
public class InsertRatings extends ArrayList<Reviews> {

    private ArrayList<Reviews> listData;
    Reviews data;
    private static final Random RANDOM = new Random();

    public ArrayList<Reviews> InsertList() {
        listData = new ArrayList<>();

        for (int i = 0; i <= 300; i++) {

            data = new Reviews();
            data.setIdReview(i);
            data.setRateReview(getRateReview());
            data.setTextReview(getTextreview());
            data.setIdUser(getIdUser());
            data.setIdProduct(getIdProduct());
            listData.add(i, data);
        }

        return listData;

    }

    private Integer getIdProduct() {

        switch (RANDOM.nextInt(30)) {
            default:
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 15;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 19:
                return 19;
            case 20:
                return 20;
            case 21:
                return 21;
            case 22:
                return 22;
            case 23:
                return 23;
            case 24:
                return 24;
            case 25:
                return 25;
            case 26:
                return 26;
            case 27:
                return 27;
            case 28:
                return 28;
            case 29:
                return 29;
        }

    }

    private Integer getIdUser() {
        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
        }
    }

    private String getTextreview() {

        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return "Good Product";
            case 1:
                return "Very good Product";
            case 2:
                return "bad product";
            case 3:
                return "nice product";
            case 4:
                return "Product is good";
        }

    }

    private int getRateReview() {
        switch (RANDOM.nextInt(5)) {
            default:
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
        }



    }


}