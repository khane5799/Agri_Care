package com.example.agricare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

public class Result extends AppCompatActivity {
    TextView moreinfo,bblight,bbd,bbdt,bbt,bb_symptoms,bb_symptomsd,bb_symptomst,bb_symptomsdt,
            bb_managment,bb_managmentd,bb_managmentt,bb_managmentdt;
    Button i1,i2,i3,i5,i6,i7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        moreinfo=findViewById(R.id.moreinfo);

        i1=findViewById(R.id.i1);
        i2=findViewById(R.id.i2);
        i3=findViewById(R.id.i3);
        i5=findViewById(R.id.i5);
        i6=findViewById(R.id.i6);
        i7=findViewById(R.id.i7);

        //----------Translation-----------


        //-----for insect chewing---------
        bblight=findViewById(R.id.bblight);
        bbd=findViewById(R.id.bbd);
        bbt=findViewById(R.id.bbt);
        bbdt=findViewById(R.id.bbdt);

        //----------for symptoms---------
        bb_symptoms=findViewById(R.id.bb_symptoms);
        bb_symptomsd=findViewById(R.id.bb_symptomsd);
        bb_symptomst=findViewById(R.id.bb_symptomst);
        bb_symptomsdt=findViewById(R.id.bb_symptomsdt);

        //----------for managment---------------
        bb_managment=findViewById(R.id.bb_managment);
        bb_managmentd=findViewById(R.id.bb_managmentd);
        bb_managmentt=findViewById(R.id.bb_managmentt);
        bb_managmentdt=findViewById(R.id.bb_managmentdt);



        moreinfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SpannableString More_Info = new SpannableString("More Info");
                More_Info.setSpan(new UnderlineSpan(), 0, More_Info.length(), 0);
                moreinfo.setText(More_Info);
                String url = "https://extension.missouri.edu/publications/ipm1025?p=4#";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);

            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Monterey-LG3190-Liqui-Cop-Fungicidal-32-Ounce/dp/B005G6J3CO/ref=sr_1_13?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-13";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/BioAdvanced-701270A-Effective-Fungicide-Prevention/dp/B0035KNZJU/ref=sr_1_4?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-4";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Southern-Ag-Liquid-Copper-Fungicide/dp/B0052NL4FK/ref=sr_1_3?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-3";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Ortho-Garden-Disease-Control-Concentrate/dp/B00KYP5S9Y/ref=sr_1_2?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-2";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Spectracide-Multi-Purpose-Fungicide-16-Ounce-Concentrate/dp/B0035H0RA8/ref=sr_1_8?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-8";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Southern-Ag-Surfactant-Herbicides-Non-Ionic/dp/B004XDHRCE/ref=sr_1_12?crid=15NAACXD60J64&keywords=cotton+Bacterial+Blight+disease&qid=1656754856&sprefix=cotton+bacterial+blight+disease%2Caps%2C298&sr=8-12";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        //----------Translation-----------------

        bblight.setClickable(true);
        bblight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,bblight.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        bbt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        bbd.setClickable(true);
        bbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,bbd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        bbdt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        bb_symptoms.setClickable(true);
        bb_symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,bb_symptoms.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        bb_symptomst.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        bb_symptomsd.setClickable(true);
        bb_symptomsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,bb_symptomsd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        bb_symptomsdt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        bb_managment.setClickable(true);
        bb_managment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,bb_managment.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        bb_managmentt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        bb_managmentd.setClickable(true);
        bb_managmentd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,bb_managmentd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        bb_managmentdt.setText(translatedText);

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