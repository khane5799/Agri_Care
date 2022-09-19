package com.example.agricare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

public class general extends AppCompatActivity {
TextView gmoreinfo,gnrl,gnrl1,howto,howtot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        gmoreinfo=findViewById(R.id.gmoreinfo);
        gnrl=findViewById(R.id.gnrl);
        gnrl1=findViewById(R.id.gnrl1);
        howto=findViewById(R.id.howto);
        howtot=findViewById(R.id.howtot);
                    //*********************************************
                    //----------- for More Information -------------
                    //*********************************************
        gmoreinfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SpannableString More_Info = new SpannableString("More Info");
                More_Info.setSpan(new UnderlineSpan(), 0, More_Info.length(), 0);
                gmoreinfo.setText(More_Info);
                String url = "https://extension.missouri.edu/publications/ipm1025?p=4#"; //URL to redirect
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);

            }
        });
                    //*********************************************
                    //---------------- for translation ------------
                    //*********************************************
gnrl.setClickable(true);
gnrl.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,gnrl.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                       gnrl1.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });

    }
});

howto.setClickable(true);
howto.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,howto.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                       howtot.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });

    }
});
                    //*********************************************
                    //---------------- TAP ANIMATION--------------
                    //*********************************************

// new TapTargetSequence(this)
//         .targets(
//                TapTarget.forView(howto,"Tap on Text","Tap on Text")
//                        .outerCircleColor(R.color.leaf)
//                        .outerCircleAlpha(0.96f)
//                        .targetCircleColor(R.color.white)
//                        .titleTextSize(20)
//                        .titleTextColor(R.color.white)
//                        .descriptionTextSize(10)
//                        .descriptionTextColor(R.color.black)
//                        .textColor(R.color.black)
//                        .textTypeface(Typeface.SANS_SERIF)
//                        .dimColor(R.color.black)
//                        .drawShadow(true)
//                        .cancelable(false)
//                        .tintTarget(true)
//                        .transparentTarget(true)
//                        .targetRadius(60),
//                TapTarget.forView(gnrl,"Tap on Text","Tap on Text")
//                        .outerCircleColor(R.color.leaf)
//                        .outerCircleAlpha(0.96f)
//                        .targetCircleColor(R.color.white)
//                        .titleTextSize(20)
//                        .titleTextColor(R.color.white)
//                        .descriptionTextSize(10)
//                        .descriptionTextColor(R.color.black)
//                        .textColor(R.color.black)
//                        .textTypeface(Typeface.SANS_SERIF)
//                        .dimColor(R.color.black)
//                        .drawShadow(true)
//                        .cancelable(false)
//                        .tintTarget(true)
//                        .transparentTarget(true)
//                        .targetRadius(60)
//                        ).start();

    }
}