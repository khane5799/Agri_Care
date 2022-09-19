package com.example.agricare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class splashscreen extends AppCompatActivity {
   // ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // progressBar=findViewById(R.id.progressBar);
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 2 seconds
                    sleep(2*1000);

                    // After 2 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),Login.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();
    }
}