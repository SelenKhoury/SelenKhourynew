package com.example.selenkhoury;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    private EditText editTextPassword , editTextEmailAddress;
    private Button buttonCancel ,buttonRegister;
    private TextView textView;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonRegister = findViewById(R.id.buttonRegister);
        textView = findViewById(R.id.textView);

        preferences = getSharedPreferences("Userinfo", 0);

    }

    public void register (View view){
        String input_mail = editTextEmailAddress.getText().toString();
        String input_password = editTextPassword.getText().toString();
        if (input_mail.length()>0) {
            // open preferences file
            SharedPreferences.Editor editor = preferences.edit();
            // save key , value data
            editor.putString("email", input_mail);
            editor.putString("password", input_password);

            editor.apply();
            Toast.makeText(this, "user registered!", Toast.LENGTH_LONG).show();
            Intent intent_main = new Intent(this, MainActivity.class);
            startActivity(intent_main);
        }else{
            Toast.makeText(this,"Empty values,please insert !",Toast.LENGTH_LONG).show();
        }

    }
    public void cancel (View view){
        Intent intent_main = new Intent(this, MainActivity.class);
        startActivity(intent_main);

    }

}
