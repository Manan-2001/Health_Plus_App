package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {

     DatabaseReference databaseRef;
    ListView orderDetailList;
    List<LabTestDetailDataBase> cartList;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        btnBack=findViewById(R.id.buttonODBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailActivity.this, OrderDetailsOptionActivity.class));
            }
        });

        orderDetailList=findViewById(R.id.listViewOD);
        databaseRef = FirebaseDatabase.getInstance().getReference("Cart");
        cartList = new ArrayList<>();
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cartList.clear();
                for (DataSnapshot cartDataSnapshot: dataSnapshot.getChildren()){
                    LabTestDetailDataBase labTestDetailDataBase=cartDataSnapshot.getValue(LabTestDetailDataBase.class);
                    cartList.add(labTestDetailDataBase);
                }
                ListAdapter adapter=new ListAdapter(OrderDetailActivity.this,cartList);
                orderDetailList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}