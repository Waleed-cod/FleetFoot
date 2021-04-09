package com.codembeded.fleetfoot.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;

import com.codembeded.fleetfoot.R;
import com.codembeded.fleetfoot.adapter.AdapterForPickUp;
import com.codembeded.fleetfoot.models.DropModels;

import java.util.ArrayList;

public class PickUp extends AppCompatActivity {

    RecyclerView pickUp_rv;
    ArrayList<DropModels> data = new ArrayList<>();
    AdapterForPickUp adapterForPickUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);
        pickUp_rv = findViewById(R.id.pickup_rv);

        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));
        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));
        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));
        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));
        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));

        adapterForPickUp = new AdapterForPickUp(data,this);
        pickUp_rv.setLayoutManager(new LinearLayoutManager(this));
        pickUp_rv.setAdapter(adapterForPickUp);
    }
}