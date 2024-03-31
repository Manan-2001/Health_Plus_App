package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OppointmentSuccessfullActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oppointment_successfull);

        EditText ed1=findViewById(R.id.editTextDCname);
        EditText ed2=findViewById(R.id.editTextDCAddress);
        EditText ed3=findViewById(R.id.editTextDCMobileNo);
        EditText ed4=findViewById(R.id.editTextDCPrice);
        EditText ed5=findViewById(R.id.editTextDCDate);
        EditText ed6=findViewById(R.id.editTextDCTime);



        Intent it=getIntent();
        ed1.setText(it.getStringExtra("fullname"));
        ed2.setText(it.getStringExtra("address"));
        ed3.setText(it.getStringExtra("contact"));
        ed4.setText(it.getStringExtra("fees"));
        ed5.setText("Date:-"+it.getStringExtra("date"));
        ed6.setText("Time:- "+it.getStringExtra("time"));

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);
        ed5.setKeyListener(null);
        ed6.setKeyListener(null);

        Button btnBack=findViewById(R.id.buttonDCBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OppointmentSuccessfullActivity.this, FindDoctorActivity.class));
            }
        });


    }
}