package com.example.ams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    ProgressBar progressBar ;
    FirebaseAuth mAuth ;
    EditText emailx, passwordx;
    Button signin_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView signup = findViewById(R.id.signup2);

        progressBar = findViewById(R.id.progressBar2);
        mAuth = FirebaseAuth.getInstance();
        emailx = findViewById(R.id.edtEmailAddressSignin);
        passwordx = findViewById(R.id.editTextSigninPassword);
        signin_btn = findViewById(R.id.loginbtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signin = new Intent(getApplicationContext(), signup.class);
                startActivity(signin);
                finish();
            }
        });

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email, Password ;
                Email = String.valueOf(emailx.getText());
                Password = String.valueOf(passwordx.getText());


                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(Login.this, "email empty", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(Login.this, "password empty", Toast.LENGTH_SHORT).show();
                }

                else {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(Email, Password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Login Successful",
                                                Toast.LENGTH_SHORT).show();
                                        Intent homepage = new Intent(getApplicationContext(), com.example.ams.ParkingActivity.class);
                                        startActivity(homepage);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Login.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}