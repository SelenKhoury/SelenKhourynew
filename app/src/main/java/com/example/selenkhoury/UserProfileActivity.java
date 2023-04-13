package com.example.selenkhoury;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ImageView imageView = findViewById(R.id.chpp);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle intent here
                Toast.makeText(UserProfileActivity.this, "Camera clicked",Toast.LENGTH_SHORT).show();
                Intent x = new Intent(UserProfileActivity.this,CameraActivity.class);
                x.putExtra("cpp",R.drawable.ic_baseline_photo_camera_24);
                startActivity(x);

            }
        });
    }


/////// تزبيييططططط
  /*  public void changepicp(@NonNull ImageView imageView) {
        switch (imageView.getId()) {
            case R.id.cpp: {
                Toast.makeText(UserProfileActivity.this, "Camera clicked",Toast.LENGTH_SHORT).show();
                Intent x = new Intent(this, CameraActivity.class);
                startActivity(x);
                break;
            }
        }
    }*/
}
