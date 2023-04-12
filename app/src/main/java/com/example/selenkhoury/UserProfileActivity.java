package com.example.selenkhoury;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {

    ImageView cpp ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
    }
/////// تزبيييططططط
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cpp: {
                Toast.makeText(UserProfileActivity.this, "Camera clicked",Toast.LENGTH_SHORT).show();
                Intent x = new Intent(this, CameraActivity.class);
                startActivity(x);
                break;
            }
        }
        return true;
    }

    public void changepp (@NonNull ImageView ImageView) {
        switch (ImageView.getBaseline()) {
            case R.id.cpp: {
                Toast.makeText(UserProfileActivity.this, "Camera clicked", Toast.LENGTH_SHORT).show();
                Intent x = new Intent(this, CameraActivity.class);
                startActivity(x);
                break;
            }
        }

    }}
