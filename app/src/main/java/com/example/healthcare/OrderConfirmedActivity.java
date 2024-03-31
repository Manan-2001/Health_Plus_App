package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OrderConfirmedActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmed);
        EditText edUserName=findViewById(R.id.editTextOCUsername);
        EditText edProduct=findViewById(R.id.editTextOCProduct);
        EditText edPrice=findViewById(R.id.editTextOCPrice);
        Intent it=getIntent();
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        edUserName.setText(user.getEmail().toString());
        edProduct.setText(it.getStringExtra("product"));
        edPrice.setText(it.getStringExtra("price"));

        edUserName.setKeyListener(null);
        edProduct.setKeyListener(null);
        edPrice.setKeyListener(null);

        Button btnBack=findViewById(R.id.buttonOCBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderConfirmedActivity.this,LabTestActivity.class));
            }
        });
    }
}