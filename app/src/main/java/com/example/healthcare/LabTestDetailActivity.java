package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LabTestDetailActivity extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnBack;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference labtestDBRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);
        tvPackageName=findViewById(R.id.textViewPackageName);
        tvTotalCost=findViewById(R.id.textViewCartTotalCost);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        edDetails=findViewById(R.id.editTextMultiLine);
        edDetails.setKeyListener(null);

        Intent it=getIntent();
       tvPackageName.setText(it.getStringExtra("text1"));
       edDetails.setText(it.getStringExtra("text2"));
       tvTotalCost.setText(it.getStringExtra("text3")+"Rs");

        btnBack=findViewById(R.id.buttonLTDBack);
        Button btnAddToCart=findViewById(R.id.buttonLTDAddtoCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailActivity.this, LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                insertLabData();
                Toast.makeText(LabTestDetailActivity.this, "Product Added to the Cart", Toast.LENGTH_SHORT).show();
                Intent it=new Intent(LabTestDetailActivity.this, OrderConfirmedActivity.class);
                it.putExtra("username",user);
                it.putExtra("product",tvPackageName.getText().toString());
                it.putExtra("price",tvTotalCost.getText().toString());
                startActivity(it);            }
        });
    }
    public void insertLabData(){
        labtestDBRef= FirebaseDatabase.getInstance().getReference().child("Cart");
        String username=user.getEmail().toString();
        String product=tvPackageName.getText().toString();
        String price= tvTotalCost.getText().toString();
        LabTestDetailDataBase labTestDetailDataBase=new LabTestDetailDataBase(username,product,price);
        labtestDBRef.push().setValue(labTestDetailDataBase);
    }
}
