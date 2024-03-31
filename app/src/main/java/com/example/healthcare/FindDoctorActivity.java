package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
//        back functionality
        CardView back=findViewById(R.id.cardFDBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });

//        physician functionality
        CardView familyPhysician=findViewById(R.id.cardFDFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
//                passess heading from one activity to anathor by using intent object
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

//        ditecian functionality
        CardView ditecian=findViewById(R.id.cardFDDietician);
        ditecian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

//        dentist functionality
        CardView dentist=findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

//        surgeon functionality
        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });

//        cardiologistics functionality
        CardView cardiologistis=findViewById(R.id.cardFDCardiologistics);
        cardiologistis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologistics");
                startActivity(it);
            }
        });
    }
}