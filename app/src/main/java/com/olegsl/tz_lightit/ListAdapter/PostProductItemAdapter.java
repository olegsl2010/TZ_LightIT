package com.olegsl.tz_lightit.ListAdapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.olegsl.tz_lightit.Instances.Product;
import com.olegsl.tz_lightit.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostProductItemAdapter extends ArrayAdapter<Product> {


    private Activity myContext;
    private ArrayList<Product> datas;

    public PostProductItemAdapter(Context context, int textViewResourceId,
                                  ArrayList<Product> objects) {
        super(context, textViewResourceId, objects);

        myContext = (Activity) context;
        datas = objects;
    }

    static class ViewHolder {
        @Bind(R.id.postTitleProduct) TextView postTitleProduct;
        @Bind(R.id.postImageProduct)ImageView postImageProduct;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public Product getItem(int i) {

        return datas.get(i);
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) myContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.post_item_product, parent, false);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(viewHolder.postImageProduct.getContext())
                .load(datas.get(position).getPostImageProduct())
                .fitCenter()
                .into(viewHolder.postImageProduct);
        viewHolder.postTitleProduct.setText(getItem(position).getPostTitleProduct());



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
