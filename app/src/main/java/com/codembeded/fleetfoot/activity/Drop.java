package com.codembeded.fleetfoot.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.codembeded.fleetfoot.R;
import com.codembeded.fleetfoot.adapter.AdapterForDrop;
import com.codembeded.fleetfoot.models.DropModels;

import java.util.ArrayList;

public class Drop extends AppCompatActivity {

    RecyclerView drop_rv;
    ArrayList<DropModels> data = new ArrayList<>();
    AdapterForDrop adapterForDrop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop);

        drop_rv = findViewById(R.id.drop_rv);

        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));
        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));
        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));
        data.add(new DropModels("James Bond","Manchester","15/02/2021","01:12 pm"));

        adapterForDrop = new AdapterForDrop(data,this);
        drop_rv.setLayoutManager(new LinearLayoutManager(this));
        drop_rv.setAdapter(adapterForDrop);
    }
}