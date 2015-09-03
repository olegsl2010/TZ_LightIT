package com.olegsl.tz_lightit.ListAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.olegsl.tz_lightit.Instances.Reviews;
import com.olegsl.tz_lightit.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by apple on 03.09.15.
 */
public class PostReviewsItemAdapter extends ArrayAdapter<Reviews> {


    private Activity myContext;
    private ArrayList<Reviews> datas;

    public PostReviewsItemAdapter(Context context, int textViewResourceId,
                                  ArrayList<Reviews> objects) {
        super(context, textViewResourceId, objects);

        myContext = (Activity) context;
        datas = objects;
    }

    static class ViewHolder {
        @Bind(R.id.ratingBar) RatingBar ratingBar;
        @Bind(R.id.textRating)TextView textRatingBar;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public Reviews getItem(int i) {

        return datas.get(i);
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) myContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.post_item_review, parent, false);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

       viewHolder.ratingBar.setRating(getItem(position).getRateReview());
        viewHolder.textRatingBar.setText(getItem(position).getTextReview());


        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

}