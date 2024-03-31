package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OrderDetailsOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_option);
        CardView booking=findViewById(R.id.cardODBookingDetails);
        CardView labtest=findViewById(R.id.cardODLabtestDetail);
        CardView back=findViewById(R.id.cardExit);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsOptionActivity.this, AppointmentsActivity.class));
            }
        });

        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsOptionActivity.this,OrderDetailActivity.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsOptionActivity.this, HomeActivity.class));
            }
        });
    }
}