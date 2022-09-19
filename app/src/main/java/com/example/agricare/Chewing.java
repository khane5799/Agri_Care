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

public class Chewing extends AppCompatActivity {
    Button insect1,insect2,insect3,insect4,insect5,insect6;
    TextView insect_moreinfo,insectchewing,insectchewingd,insectt,insectdt,symptoms,symptomsd,symptomst,symptomsdt,
            managment,managmentd,managmentt,managmentdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chewing);
        insect_moreinfo=findViewById(R.id.insect_moreinfo);
        insect1=findViewById(R.id.insect1);
        insect2=findViewById(R.id.insect2);
        insect3=findViewById(R.id.insect3);
        insect4=findViewById(R.id.insect4);
        insect5=findViewById(R.id.insect5);
        insect6=findViewById(R.id.insect6);
        //----------Translation-----------


        //-----for insect chewing---------
        insectchewing=findViewById(R.id.insectchewing);
        insectchewingd=findViewById(R.id.insectchewingd);
        insectt=findViewById(R.id.insectt);
        insectdt=findViewById(R.id.insectdt);

        //----------for symptoms---------
        symptoms=findViewById(R.id.symptoms);
        symptomsd=findViewById(R.id.symptomsd);
        symptomst=findViewById(R.id.symptomst);
        symptomsdt=findViewById(R.id.symptomsdt);

        //----------for managment---------------
        managment=findViewById(R.id.managment);
        managmentd=findViewById(R.id.managmentd);
        managmentt=findViewById(R.id.managmentt);
        managmentdt=findViewById(R.id.managmentdt);



        insect_moreinfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SpannableString More_Info = new SpannableString("More Info");
                More_Info.setSpan(new UnderlineSpan(), 0, More_Info.length(), 0);
                insect_moreinfo.setText(More_Info);
                String url = "https://agrinfobank.com.pk/top-10-insect-pests-of-cotton-in-pakistan/";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);

            }
        });
        insect1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Bonide-BND212-Horticultural-Spray-212-Concentrate/dp/B000FOONE0/ref=sr_1_8?crid=3KTAQ2WFVHOJ0&keywords=insecticidal+soap&qid=1657013086&sprefix=%2Caps%2C1245&sr=8-8";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        insect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Bonide-Product-951-Systemic-Control/dp/B000BX1HKI/ref=sr_1_24?crid=3KTAQ2WFVHOJ0&keywords=insecticidal+soap&qid=1657013086&sprefix=%2Caps%2C1245&sr=8-24";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        insect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Monterey-LG6135-Garden-Spinosad-Concentrate/dp/B002BP12LI/ref=sxin_18?asc_contentid=amzn1.osa.222f0859-3091-452e-b2f6-f8e5c6c47af3.ATVPDKIKX0DER.en_US&asc_contenttype=article&ascsubtag=amzn1.osa.222f0859-3091-452e-b2f6-f8e5c6c47af3.ATVPDKIKX0DER.en_US&content-id=amzn1.sym.fbbb48ea-8f4f-47b9-a693-6439c94fd040%3Aamzn1.sym.fbbb48ea-8f4f-47b9-a693-6439c94fd040&creativeASIN=B002BP12LI&crid=3KTAQ2WFVHOJ0&cv_ct_cx=insecticidal+soap&cv_ct_id=amzn1.osa.222f0859-3091-452e-b2f6-f8e5c6c47af3.ATVPDKIKX0DER.en_US&cv_ct_pg=search&cv_ct_we=asin&cv_ct_wn=osp-single-source-earns-comm&keywords=insecticidal+soap&linkCode=oas&pd_rd_i=B002BP12LI&pd_rd_r=a65e5e32-e21a-4890-ad6d-027ef3726177&pd_rd_w=T6kEi&pd_rd_wg=Nyshq&pf_rd_p=fbbb48ea-8f4f-47b9-a693-6439c94fd040&pf_rd_r=TRF4HQMY09F3AHGD7394&qid=1657013086&sprefix=%2Caps%2C1245&sr=1-1-071eec3b-aca5-449e-bbff-36c3e2e2e9e2&tag=bobvila-20";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        insect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Insect-Soap-Concentrate-qt/dp/B000HCNSWI/ref=sr_1_4?crid=3KTAQ2WFVHOJ0&keywords=insecticidal+soap&qid=1657013086&sprefix=%2Caps%2C1245&sr=8-4";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        insect5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Gardening-Botanical-Insecticide-Pyrethrin-Concentrate/dp/B01MSWWEX1/ref=sr_1_33?crid=3KTAQ2WFVHOJ0&keywords=insecticidal+soap&qid=1657013086&sprefix=%2Caps%2C1245&sr=8-33";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });
        insect6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Systemic-Granules-22-4-lb/dp/B000BWZ9U8/ref=sr_1_31?crid=3KTAQ2WFVHOJ0&keywords=insecticidal+soap&qid=1657013086&sprefix=%2Caps%2C1245&sr=8-31";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

        //----------Translation-----------------

        insectchewingd.setClickable(true);
                insectchewingd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,insectchewingd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                       insectdt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        insectchewing.setClickable(true);
                insectchewing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,insectchewing.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                       insectt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        symptoms.setClickable(true);
        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,symptoms.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        symptomst.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        symptomsd.setClickable(true);
        symptomsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,symptomsd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        symptomsdt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        managment.setClickable(true);
        managment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,managment.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        managmentt.setText(translatedText);

                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("Error",ErrorText);
                    }
                });
            }
        });
        managmentd.setClickable(true);
        managmentd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,Language.URDU,managmentd.getText().toString()
                );
                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        managmentdt.setText(translatedText);

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
//xcnbvcnbvcnbcbvcnbvcnbvcnb