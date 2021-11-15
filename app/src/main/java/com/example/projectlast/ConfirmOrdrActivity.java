package com.example.projectlast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

public class ConfirmOrdrActivity extends AppCompatActivity {
    RecyclerView orderRv;
    ConfirmOrdrActivityAdapter confirmOrdrActivityAdapter;
    Activity context;
    UpdateSelectedItems updateSelectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Confirm Order ");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        orderRv = findViewById(R.id.order_rv);
        confirmOrdrActivityAdapter = new ConfirmOrdrActivityAdapter(context);
        orderRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        orderRv.setAdapter(confirmOrdrActivityAdapter);
    }
}