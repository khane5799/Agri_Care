package com.example.agricare;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agricare.ml.CnnModel;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.auth.FirebaseAuth;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import de.hdodenhof.circleimageview.CircleImageView;

public class Scanning extends AppCompatActivity {
    Button process, select_photo;
    TextView scanlogin, tvlogout, outputhay,outputhay1;
    Bitmap bitmap;
    CircleImageView bctarialblight,cp,is,cl;
    ImageView img;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning);
        img = findViewById(R.id.img);
        select_photo = findViewById(R.id.select_photo);
        process = findViewById(R.id.process);
        bctarialblight = findViewById(R.id.bctarialblight);
        cp = findViewById(R.id.cp);
        is = findViewById(R.id.is);
        cl = findViewById(R.id.cl);
        outputhay = findViewById(R.id.outputhay);
        outputhay1 = findViewById(R.id.outputhay1);
        select_photo = findViewById(R.id.select_photo);
        mAuth = FirebaseAuth.getInstance();
        select_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/*");
//                startActivityForResult(intent, 100);

                ImagePicker.with(Scanning.this)
                        .crop()    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
                //Toast.makeText(Scanning.this, "Please select cotton leaf photo", Toast.LENGTH_LONG).show();
                outputhay.setVisibility(View.GONE);
                outputhay1.setVisibility(View.GONE);

            }
        });
        cp.setClickable(true);
        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Scanning.this,general.class);
                startActivity(intent);
            }
        });
        is.setClickable(true);
        is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Scanning.this,Chewing.class);
                startActivity(intent);

            }
        });
        bctarialblight.setClickable(true);
        bctarialblight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Scanning.this,Result.class);
                startActivity(intent);

            }
        });
        cl.setClickable(true);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Scanning.this,Curl.class);
                startActivity(intent);

            }
        });

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bitmap = Bitmap.createScaledBitmap(bitmap, 150, 150, true);
                try {
                    CnnModel model = CnnModel.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 150, 150, 3}, DataType.FLOAT32);
                    ByteBuffer byteBuffer =ByteBuffer.allocateDirect(4 * 150 * 150 * 3);
                    byteBuffer.order(ByteOrder.nativeOrder());
                    int [] intValues =new int[150 * 150 ];
                    bitmap.getPixels(intValues,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());
                    int pixel=0;
                    for(int i=0;i<150;i++) {
                        for (int j = 0; j < 150; j++){
                            int val =intValues[pixel++];
                            byteBuffer.putFloat(((val >> 16)& 0xFF)*(1.f/1));
                            byteBuffer.putFloat(((val >> 8)& 0xFF)*(1.f/1));
                            byteBuffer.putFloat((val & 0xFF)*(1.f/1));
                        }
                    }
                    inputFeature0.loadBuffer(byteBuffer);

                    // Runs model inference and gets result.
                    CnnModel.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                    float[] confidance=outputFeature0.getFloatArray();
                    int maxpos=0;
                    float maxconfidance=0;
                    for(int i=0;i<confidance.length;i++)
                    {
                        if(confidance[i]>maxconfidance)
                        {
                            maxconfidance=confidance[i];
                            maxpos=i;
                        }

                    }
//                    int[] classes={0,1,2,3};
//                    if(outputFeature0.getFloatArray()[0]==0||outputFeature0.getFloatArray()[0]==1||outputFeature0.getFloatArray()[0]==2||outputFeature0.getFloatArray()[0]==3)
//                    {
//                        Toast.makeText(Scanning.this, "cant be pridicted", Toast.LENGTH_SHORT).show();
                    outputhay.setText("Bactarial Blight"+outputFeature0.getFloatArray()[0]+"\n"+
                            "Attack of leaf sucking and chewing"+outputFeature0.getFloatArray()[1]+"\n"+
                            "No disease"+outputFeature0.getFloatArray()[2]+"\n"+"Cotton Leaf Curl Virus"+outputFeature0.getFloatArray()[3]);


                    if(outputFeature0.getFloatArray()[0]==0&&outputFeature0.getFloatArray()[1]==0&&outputFeature0.getFloatArray()[2]==0&&outputFeature0.getFloatArray()[3]==0)
                    {
                        //Toast.makeText(Scanning.this, "please choose correct image", Toast.LENGTH_SHORT).show();
                        outputhay1.setText("Please choose leaf image");
                        outputhay1.setTypeface(Typeface.create("font_family_display_1_material",Typeface.ITALIC));
                        outputhay1.setTextColor(Color.RED);
                        outputhay1.setVisibility(View.VISIBLE);
                    }
                    else
                    {

                        //Toast.makeText(Scanning.this, "cant be pridicted", Toast.LENGTH_SHORT).show();

                        outputhay.setVisibility(View.VISIBLE);
                        outputhay.setTypeface(Typeface.create("sans-serif-condensed",Typeface.BOLD));
                    }

                    model.close();
                } catch (IOException e) {
                    // TODO   Handle the exception
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100) {
//            img.setImageURI(data.getData());

        Uri uri=data.getData();
        img.setImageURI(uri);

            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}

