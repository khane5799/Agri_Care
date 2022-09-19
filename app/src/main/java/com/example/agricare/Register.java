package com.example.agricare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class Register extends AppCompatActivity {
    private TextView tvlogin,ptv;
    private Button register_bnt;
    private EditText etname;
    private EditText etLoginEmail;
    ProgressBar pb;
    private EditText etLoginPass;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvlogin=findViewById(R.id.tvlogin);
        register_bnt=findViewById(R.id.rigester_btn);
        etname=findViewById(R.id.etname);
        pb=findViewById(R.id.pb);
        ptv=findViewById(R.id.ptv);
        etLoginEmail=findViewById(R.id.etLoginEmail);
        etLoginPass=findViewById(R.id.etLoginPass);
        mauth=FirebaseAuth.getInstance();

      register_bnt.setOnClickListener(new View.OnClickListener() {
          @Override

          public void onClick(View v) {
              pb.setVisibility(View.VISIBLE);
              ptv.setVisibility(View.VISIBLE);
              createUser();
          }
      });

        tvlogin.setOnClickListener(view -> startActivity(new Intent(Register.this, Login.class)));
    }

    private void createUser(){
        String email = etLoginEmail.getText().toString();
        String password = etLoginPass.getText().toString();

        if (TextUtils.isEmpty(email)){
            etLoginEmail.setError("Email cannot be empty");
            etLoginEmail.requestFocus();
            pb.setVisibility(View.INVISIBLE);
        }else if (TextUtils.isEmpty(password)){
            etLoginPass.setError("Password cannot be empty");
            etLoginPass.requestFocus();
            pb.setVisibility(View.INVISIBLE);
        }else{
            mauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {

                    mauth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<Void> task) {
                            if(task.isSuccessful())
                            {

                                Toast.makeText(Register.this, "Please check your Mailbox to varify email ", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Register.this,Login.class);
                                startActivity(intent);


                            }
                            else
                            {
                                Toast.makeText(Register.this, "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                pb.setVisibility(View.INVISIBLE);
                            }
                        }
                    });


//                    Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(Register.this, Login.class));
                } else {
                    Toast.makeText(Register.this, "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    pb.setVisibility(View.GONE);
                }


            });
        }
    }
}
