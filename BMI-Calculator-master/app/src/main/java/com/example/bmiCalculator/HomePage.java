package com.example.bmiCalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class HomePage extends AppCompatActivity {

    public HomePage() {
    }


    private Button mcalculatebmi;
    private TextView mcurrentheight;
    private TextView currentweight;
    private TextView mcurrentage;
    private ImageView mincrementage, mincrementweight, mdecrementage, mdecrementweight;
    private SeekBar mseekbarforheight;
    private RelativeLayout mfemale, mmale;

    int intweight = 55;
    int intage =22;
    int cureentprogress;
    String mintprogress = "170";
    String typeofuser = "0";
    String weight2 = "55";
    String age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mcalculatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentheight = findViewById(R.id.currentheight);
        currentweight = findViewById(R.id.currentweight);
        mincrementage = findViewById(R.id.incrementage);
        mincrementweight = findViewById(R.id.incrementweight);
        mdecrementweight = findViewById(R.id.decrementweight);
        mdecrementage = findViewById(R.id.decrementage);
        mseekbarforheight = findViewById(R.id.seekbar);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);


        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });


        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cureentprogress = progress;
                mintprogress = String.valueOf(cureentprogress);
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = intage++;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });
        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = intweight++;
                weight2 = String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = intage--;
                age2 = String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });
        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = intweight--;
                weight2 = String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });
        mcalculatebmi=findViewById(R.id.calculatebmi);
        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select your gender first",Toast.LENGTH_SHORT).show();
                } else if (mintprogress.equals("0")) {
                    Toast.makeText(getApplicationContext(),"Set your height first",Toast.LENGTH_SHORT).show();
                } else if (intage==0 || intage<0) {
                    Toast.makeText(getApplicationContext(),"Incorrect age",Toast.LENGTH_SHORT).show();
                } else if (intweight==0 || intweight<0) {
                    Toast.makeText(getApplicationContext(),"Incorrect weight",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent =new Intent(HomePage.this,BMICalculated.class);
                    intent.putExtra("Gender", typeofuser);
                    intent.putExtra("Height", mintprogress);
                    intent.putExtra("Weight", weight2);
                    intent.putExtra("Age", age2);
                    startActivity(intent);
                }


            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}