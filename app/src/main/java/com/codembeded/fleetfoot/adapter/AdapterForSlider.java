package com.codembeded.fleetfoot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codembeded.fleetfoot.R;
import com.codembeded.fleetfoot.models.ImageSliderModels;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class AdapterForSlider extends SliderViewAdapter<AdapterForSlider.ViewHolder> {

    List<ImageSliderModels> list;
    Context ctx;

    public AdapterForSlider(List<ImageSliderModels> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_image_slider_box,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Glide.with(ctx).load(list.get(position).getImage()).into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public class ViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_auto_image_slider);
        }
    }
}
