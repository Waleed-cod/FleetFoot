package com.codembeded.fleetfoot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codembeded.fleetfoot.R;
import com.codembeded.fleetfoot.activity.Drop;
import com.codembeded.fleetfoot.models.DropModels;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterForDrop extends RecyclerView.Adapter<AdapterForDrop.ViewHolder> {

    ArrayList<DropModels> list;
    Context ctx;

    public AdapterForDrop(ArrayList<DropModels> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drop_box,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.address.setText(list.get(position).getAddress());
        holder.date.setText(list.get(position).getDate());
        holder.time.setText(list.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,address, date, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_drop_box);
            address = itemView.findViewById(R.id.address_drop_box);
            date = itemView.findViewById(R.id.date_drop_box);
            time = itemView.findViewById(R.id.time_drop_box);
        }
    }
}
