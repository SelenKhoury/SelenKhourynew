package com.example.selenkhoury;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
//Android Vertical ScrollView Tutorial Example - Android Studio Tutorial

    ImageButton imageButton0,imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageButton imageButton0 = findViewById(R.id.imageButton0);
        imageButton0.setOnClickListener(this);
        ImageButton imageButton1 = findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(this);
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this);
        ImageButton imageButton4 = findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(this);
        ImageButton imageButton5 = findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(this);
        ImageButton imageButton6 = findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton0:
                    Intent intent0 = new Intent(MainActivity2.this, ItalianfoodActivity.class);
                    startActivity(intent0);
                    break;
                case R.id.imageButton1:
                    Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                    /*
                case R.id.imageButton2:
                    Intent intent2 = new Intent(MainActivity2.this, Activity2.class);
                    startActivity(intent2);
                    break;
                case R.id.imageButton3:
                    Intent intent3 = new Intent(MainActivity2.this, Activity2.class);
                    startActivity(intent3);
                    break;
                case R.id.imageButton4:
                    Intent intent4 = new Intent(MainActivity2.this, Activity2.class);
                    startActivity(intent4);
                    break;
                case R.id.imageButton5:
                    Intent intent5 = new Intent(MainActivity2.this, Activity2.class);
                    startActivity(intent5);
                    break;
                case R.id.imageButton6:
                    Intent intent6 = new Intent(MainActivity2.this, Activity2.class);
                    startActivity(intent6);
                    break;
            }
        }*/
            }
        }}
