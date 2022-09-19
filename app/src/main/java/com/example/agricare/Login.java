package com.example.agricare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login extends AppCompatActivity {
    TextView tvRegisterhere,ptv;
    ImageView gbtn;
    Button btnlogin;
    EditText etLoginEmail;
    EditText etLoginPass;
    FirebaseAuth mauth;
    CheckBox showpass,remember_me;
    SharedPreferences sharedPreferences;
    ProgressBar pb;
    public static final String filename="login";
    public static final String Username="username";
    public static final String Password="passwprd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvRegisterhere = findViewById(R.id.tvRegisterHere);
        btnlogin = findViewById(R.id.btnLogin);
        ptv = findViewById(R.id.ptv);
        pb = findViewById(R.id.pb);
        remember_me = findViewById(R.id.remember_me);
        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPass = findViewById(R.id.etLoginPass);
        mauth = FirebaseAuth.getInstance();

        SharedPreferences prefrencess=getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox=prefrencess.getString("remember","");
        if(checkbox.equals("true"))
        {
            Intent intent=new Intent(Login.this,Scanning.class);
            startActivity(intent);
            //Toast.makeText(this, "Scanning activity", Toast.LENGTH_SHORT).show();
        }
        else if(checkbox.equals("false"))
        {
            //Toast.makeText(this, "Please Sign in First", Toast.LENGTH_SHORT).show();
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
                pb.setVisibility(View.VISIBLE);
                ptv.setVisibility(View.VISIBLE);
            }
        });


        tvRegisterhere.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Register.class)));

        remember_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())
                {
                SharedPreferences prefrencess=getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = prefrencess.edit();
                editor.putString("remember","true");
                editor.apply();
                    //Toast.makeText(Login.this, "checked", Toast.LENGTH_SHORT).show();

                }
                else if(!compoundButton.isChecked())
                {
                    SharedPreferences prefrencess=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefrencess.edit();
                    editor.putString("remember","false");
                    editor.apply();
                   // Toast.makeText(Login.this, "unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginUser() {
        String email = etLoginEmail.getText().toString();
        String password = etLoginPass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etLoginEmail.setError("Email cannot be empty");
            etLoginEmail.requestFocus();
            pb.setVisibility(View.INVISIBLE);
        } else if (TextUtils.isEmpty(password)) {
            etLoginPass.setError("Password cannot be empty");
            etLoginPass.requestFocus();
            pb.setVisibility(View.INVISIBLE);
        } else {
            mauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {
                    if(mauth.getCurrentUser().isEmailVerified())
                    {
                        //Toast.makeText(Login.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, Scanning.class));
                    }
                    else{
                        Toast.makeText(this, "Please Varify your Email", Toast.LENGTH_LONG).show();
                        pb.setVisibility(View.INVISIBLE);
                    }
                    //Toast.makeText(Login.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(Login.this, Scanning.class));
                } else {
                    Toast.makeText(Login.this, "Log in Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    pb.setVisibility(View.INVISIBLE);
                }
            });
        }
    }


}