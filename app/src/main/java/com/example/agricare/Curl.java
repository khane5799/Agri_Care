package com.example.agricare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

public class Curl extends AppCompatActivity {
TextView cmoreinfo,cl,cld,clt,cldt,cl_symptoms,cl_symptomsd,cl_symptomst,cl_symptomsdt,
         cl_managment,cl_managmentd,cl_managmentt,cl_managmentdt;
Button c1,c3,c5,c6,c7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curl);
        cmoreinfo=findViewById(R.id.cmoreinfo);
        c1=findViewById(R.id.c1);
        c3=findViewById(R.id.c3);
        c5=findViewById(R.id.c5);
        c6=findViewById(R.id.c6);
        c7=findViewById(R.id.c7);

        //----------Translation-----------


        //-----for insect chewing---------
        cl=findViewById(R.id.cl);
        cld=findViewById(R.id.cld);
        clt=findViewById(R.id.clt);
        cldt=findViewById(R.id.cldt);

        //----------for symptoms---------
        cl_symptoms=findViewById(R.id.cl_symptoms);
        cl_symptomsd=findViewById(R.id.cl_symptomsd);
        cl_symptomst=findViewById(R.id.cl_symptomst);
        cl_symptomsdt=findViewById(R.id.cl_symptomsdt);

        //----------for managment---------------
        cl_managment=findViewById(R.id.cl_managment);
        cl_managmentd=findViewById(R.id.cl_managmentd);
        cl_managmentt=findViewById(R.id.cl_managmentt);
        cl_managmentdt=findViewById(R.id.cl_managmentdt);




        cmoreinfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SpannableString More_Info = new SpannableString("More Info");
                More_Info.setSpan(new UnderlineSpan(), 0, More_Info.length(), 0);
                cmoreinfo.setText(More_Info);
                String url = "https://www.frontiersin.org/articles/10.3389/fpls.2017.01157/full";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);

            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://store.pggwrightson.co.nz/kiwicare-plant-health-spectrum-concentrate-500-ml-143948";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Southern-Ag-Liquid-Copper-Fungicide/dp/B0052NL4FK/ref=sr_1_3?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-3";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Ensure-Plant-Based-Protein-Nutrition-Vanilla/dp/B07VG8CTKZ/ref=sr_1_1?crid=230EY9DNUQ5YF&keywords=ensure+for+plant&qid=1657007398&sprefix=ensure+for+pla%2Caps%2C664&sr=8-1";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Spectracide-Multi-Purpose-Fungicide-16-Ounce-Concentrate/dp/B0035H0RA8/ref=sr_1_8?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-8";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Southern-Ag-Surfactant-Herbicides-Non-Ionic/dp/B004XDHRCE/ref=sr_1_12?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-12";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        //----------Translation-----------------

        cl.setClickable(true);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,cl.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        clt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        cld.setClickable(true);
        cld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,cld.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        cldt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        cl_symptoms.setClickable(true);
       cl_symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,cl_symptoms.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        cl_symptomst.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        cl_symptomsd.setClickable(true);
        cl_symptomsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,cl_symptomsd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        cl_symptomsdt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        cl_managment.setClickable(true);
        cl_managment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,cl_managment.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        cl_managmentt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        cl_managmentd.setClickable(true);
        cl_managmentd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,cl_managmentd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        cl_managmentdt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });





    }
}