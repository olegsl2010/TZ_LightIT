package com.olegsl.tz_lightit.ListAdapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.olegsl.tz_lightit.R;

import java.util.ArrayList;

public class PostItemAdapter extends ArrayAdapter<PostData> {


    private Activity myContext;
    private ArrayList<PostData> datas;

    public PostItemAdapter(Context context, int textViewResourceId,
                           ArrayList<PostData> objects) {
        super(context, textViewResourceId, objects);

        myContext = (Activity) context;
        datas = objects;
    }

    static class ViewHolder {
        TextView postTitleProduct;
        TextView postDescriptionProduct;
        ImageView postImageProduct;

    }

    @Override
    public PostData getItem(int i) {

        return datas.get(i);
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) myContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.postitem, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.postImageProduct = (ImageView) convertView.findViewById(R.id.PostImageProduct);
            viewHolder.postTitleProduct = (TextView) convertView.findViewById(R.id.postTitleProduct);
            viewHolder.postDescriptionProduct= (TextView) convertView.findViewById(R.id.postDescriptionProduct);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.postImageProduct.setBackgroundColor(100);
        viewHolder.postTitleProduct.setText(getItem(position).getPostTitleProduct());
        viewHolder.postDescriptionProduct.setText(getItem(position).getPostDescriptionProduct());


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
