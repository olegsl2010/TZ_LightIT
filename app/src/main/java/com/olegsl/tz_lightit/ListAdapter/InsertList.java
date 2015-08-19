package com.olegsl.tz_lightit.ListAdapter;

import java.util.ArrayList;

/**
 * Created by olegs_000 on 22.07.2015.
 */
public class InsertList extends ArrayList<PostData> {

    private ArrayList<PostData> listData;
    PostData data;

    public ArrayList<PostData> InsertList(){
        listData = new ArrayList<>();

        for (int i =0;i<=30;i++){

            data = new PostData();
            data.setPostTitleProduct("product");
            data.setPostDescriptionProduct("Product Description");
            data.setPostImageProduct("IMG");
            listData.add(i,data);}

        return listData;

    }

}
