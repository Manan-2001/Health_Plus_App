package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edEmail, edConfirmpassword;
    Button btn;
    TextView tv;
    FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(getApplicationContext(), "Already Signed in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextAppAddress);
        edEmail = findViewById(R.id.editTextAppFullName);
        edPassword = findViewById(R.id.editTextAppContactNumber);
        edConfirmpassword = findViewById(R.id.editTextAppConsultantFess);
        btn = findViewById(R.id.buttonAppBack);
        tv = findViewById(R.id.textViewRegisteredUser);
      mAuth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String Email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirmPassword = edConfirmpassword.getText().toString();
                if (password.length() == 0 || username.length() == 0 || confirmPassword.length() == 0 || Email.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill All details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmPassword) == 0) {
                        if (isValid(password)){
//                            for register user
                            mAuth.createUserWithEmailAndPassword(Email, password)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(getApplicationContext(), "Registered Successfull", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                            } else {
                                                // If sign in fails, display a message to the user.
                                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Password must contain atleast 8 charachter,digit and special case", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;

        if (passwordhere.length() < 8) {

            return false;

        } else {

            for (int p = 0; p < passwordhere.length(); p++) {

                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }

            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;

                }
            }



        for (int s = 0; s < passwordhere.length(); s++) {
            char c = passwordhere.charAt(s);
            if (c >= 33 && c <= 46 || c == 64) {
                f3 = 1;
            }
        }

        if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}


