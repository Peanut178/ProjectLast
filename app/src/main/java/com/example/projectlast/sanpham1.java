package com.example.projectlast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class sanpham1 extends AppCompatActivity {
    EditText etValue;
    Button btAdd;
    ListView listView;
    ArrayList<String> arrayList  = new ArrayList<>();
    ArrayAdapter<String>adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham1);

        etValue = findViewById(R.id.et_value);
        btAdd = findViewById(R.id.bt_add);
        listView = findViewById(R.id.list_view);

        adapter = new ArrayAdapter<>(this
                            , android.R.layout.simple_list_item_1,arrayList);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference().child("Data");

        getValue();
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sValue = etValue.getText().toString().trim();
                String skey = databaseReference.push().getKey();
                if(skey != null){
                    databaseReference.child(skey).child("value").setValue(sValue);


                }
            }
        });


    }

    private void getValue() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String sValue = dataSnapshot.child("value").getValue(String.class);
                    arrayList.add(sValue);

            }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}