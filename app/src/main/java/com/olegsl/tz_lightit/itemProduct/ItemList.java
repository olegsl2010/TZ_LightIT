package com.olegsl.tz_lightit.itemProduct;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.olegsl.tz_lightit.R;


/**
 * Created by apple on 30.07.15.
 */
public class ItemList extends Fragment {
    View rootView;
    String titleName;
TextView description;


    String descriptionProduct;
    private  int potsImageProduct;
    private RatingBar ratingBar;

    public void setTextForView(String title){
        titleName = title;

    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public void setImage(int postImage){
        this.potsImageProduct=postImage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.item_list_view, container, false);




        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleColor(Color.WHITE);
        collapsingToolbar.setTitle(titleName);

        loadBackdrop();

        addDescription();

        addRatingBar();


        return rootView;
    }

    private void addDescription() {

        description = (TextView) rootView.findViewById(R.id.description);
        description.setText(descriptionProduct);

    }

    private void loadBackdrop() {
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.backdrop);

        Glide.with(this).load(potsImageProduct).centerCrop().into(imageView);
    }

    public void addRatingBar() {

        ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBar);

     ratingBar.setRating(4);



    }


}
