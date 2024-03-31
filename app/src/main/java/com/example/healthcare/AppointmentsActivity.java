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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsActivity extends AppCompatActivity {
    ListView bookedList;
    DatabaseReference databaseRef;

    List<BookingDetail_Database> bookcartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        Button btnBack=findViewById(R.id.buttonDDBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppointmentsActivity.this, OrderDetailsOptionActivity.class));
            }
        });
        bookedList=findViewById(R.id.listViewDD);
        databaseRef = FirebaseDatabase.getInstance().getReference("BookApointment");
        bookcartList= new ArrayList<>();
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bookcartList.clear();
                for (DataSnapshot cartDataSnapshot: dataSnapshot.getChildren()){
                    BookingDetail_Database bookingDetailDataBase=cartDataSnapshot.getValue(BookingDetail_Database.class);
                    bookcartList.add(bookingDetailDataBase);
                }
                list_adapter_booking adapter=new list_adapter_booking(AppointmentsActivity.this,bookcartList);
                bookedList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}