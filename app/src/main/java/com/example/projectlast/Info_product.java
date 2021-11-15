package com.example.projectlast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Info_product extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_product);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        Intent i =getIntent();
        String value1 = i.getStringExtra("key1");
        String[] cuthair = value1.split("-");
        tv1.setText(cuthair[0]);
        tv2.setText(cuthair[1]);
        tv3.setText(cuthair[2]);
    }
}