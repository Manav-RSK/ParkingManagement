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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    TextView signin ;
    ProgressBar progressBar ;
    FirebaseAuth mAuth ;
    EditText email, password ;
    Button signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        signin = findViewById(R.id.sin2);
        email = findViewById(R.id.edtEmailAddressSignup);
        password = findViewById(R.id.editTextSignupPassword);
        signup_btn = findViewById(R.id.signupbtn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email, Password ;
                Email = String.valueOf(email.getText());
                Password = String.valueOf(password.getText());

                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(signup.this, "email empty", Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(signup.this, "password empty", Toast.LENGTH_SHORT).show();
                    return ;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Toast.makeText(signup.this , "Account created", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(signup.this, "Account already exists",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signinpage = new Intent(signup.this, com.example.ams.Login.class);
                startActivity(signinpage);
                finish();
            }
        });
    }
}