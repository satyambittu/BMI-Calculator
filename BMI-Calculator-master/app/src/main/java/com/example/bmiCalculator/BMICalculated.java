package com.example.bmiCalculator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class BMICalculated extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;
    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        setContentView(R.layout.activity_bmicalculated);
        if (getSupportActionBar() != null) {
            Objects.requireNonNull(getSupportActionBar()).setElevation(0);
            getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
            getSupportActionBar().setTitle("Result");
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1e1d1d"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
        }


        intent = getIntent();
        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        background = findViewById(R.id.contentlayout);
        mimageview =findViewById(R.id.imageView);
        mrecalculatebmi = findViewById(R.id.recalculatebmi);

        height=intent.getStringExtra("Height");
        weight =intent.getStringExtra("Weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);
        intheight = intheight/100;

        intbmi = intweight/(intheight*intheight);

        mbmi = Double.toString(intbmi);
        mbmi = String.format("%.2f", intbmi);

        if(intbmi<16){
        mbmicategory.setText("Extreme Skinny");
//        background.setBackgroundColor(Color.RED);
        mimageview.setImageResource(R.drawable.crosss);
        } else if (intbmi<16.9 && intbmi>16) {
            mbmicategory.setText("Skinny");
//            background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }
         else if (intbmi<18.4 && intbmi>17) {
            mbmicategory.setText("Mild Skinny");
//            background.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);
        }
         else if (intbmi<25 && intbmi>18.4) {
        mbmicategory.setText("Normal");
//        background.setBackgroundColor(Color.GREEN);
        mimageview.setImageResource(R.drawable.ok);
    }
         else if (intbmi<29.9 && intbmi>25) {
            mbmicategory.setText("Obese I");
//            background.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.warning);
        }
        else if(intbmi<34.9 && intbmi>29.9){
            mbmicategory.setText("Obese II");
//            background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }
        else{
            mbmicategory.setText("Obese III");
//            background.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }

        mgender.setText(intent.getStringExtra("Gender"));
        mbmidisplay.setText(mbmi);

        mrecalculatebmi = findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMICalculated.this,HomePage.class);
                startActivity(intent);
                finish();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}