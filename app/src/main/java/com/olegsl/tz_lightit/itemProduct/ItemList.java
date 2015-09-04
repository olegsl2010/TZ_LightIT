package com.olegsl.tz_lightit.itemProduct;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.olegsl.tz_lightit.Data.InsertRatings;
import com.olegsl.tz_lightit.Instances.Reviews;
import com.olegsl.tz_lightit.ListAdapter.PostReviewsItemAdapter;
import com.olegsl.tz_lightit.R;

import java.util.ArrayList;


/**
 * Created by apple on 30.07.15.
 */
public class ItemList extends Fragment {

    PostReviewsItemAdapter itemAdapter;
    View rootView;
    String titleName;
    TextView description;
    private ArrayList<Reviews> listReviews;
    private ArrayList<Reviews> reviewToList;
    InsertRatings insertRatings;
    ListView listRating;

    String descriptionProduct;
    private  int potsImageProduct;
    private  int productId;
    private RatingBar ratingBar;

    public void setTextForView(String title){
        titleName = title;

    }
    public void setProductId(int product) {
        this.productId = product;
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

        listRating = (ListView) rootView.findViewById(R.id.listViewReview);


        insertedList();

        final Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleColor(Color.WHITE);
        collapsingToolbar.setTitle(titleName);

        loadBackdrop();

        addDescription();

        addRatingBar();


        return rootView;
    }

    private void insertedList() {
        if (listReviews==null && insertRatings==null){
            insertRatings = new InsertRatings();
            listReviews = new ArrayList<>();
            listReviews = insertRatings.InsertList();

        }
        reviewToList= new ArrayList<>();
        for (int i=0;i<listReviews.size();i++){
            if(listReviews.get(i).getIdProduct()==productId){
                reviewToList.add(listReviews.get(i));
            }
        }

        toList(reviewToList);
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

        ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBarMiddle);

        ratingBar.setRating(middleRating());

    }

    private int middleRating() {
        int size =reviewToList.size();
        int summOfReviews=0;
        for (int i = 0;i<reviewToList.size();i++){
            summOfReviews+=reviewToList.get(i).getRateReview();

        }
        int middleRaiting = summOfReviews/size;
        return middleRaiting;

    }


    public void toList(ArrayList<Reviews> listReviews) {
        itemAdapter = new PostReviewsItemAdapter(getActivity(), R.layout.post_item_review, listReviews);

        listRating.setAdapter(itemAdapter);
        setListViewHeightBasedOnChildren(listRating);
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
