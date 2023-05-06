package com.example.selenkhoury;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LogInActivity extends AppCompatActivity {

    private EditText editTextTextPersonName_login, editTextNumberPassword_login, editTextPassword, editTextPersonName;
    private TextView textView2, textview3;
    private Button buttonLogIn, button_to_sign;
    private final String valid_Name = "admin";
    private final String valid_password = "1";

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextTextPersonName_login = findViewById(R.id.editTextTextPersonName_login);
        editTextNumberPassword_login = findViewById(R.id.editTextNumberPassword_login);
        textView2 = findViewById(R.id.textView2);
        textview3 = findViewById(R.id.textView3);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        button_to_sign = findViewById(R.id.button_to_sign);
        // creates a preferences file ,
        preferences = getSharedPreferences("Userinfo", 0);
         }

    public void Login(View view) {
        if (editTextNumberPassword_login.getText().toString().equals(""))
            Toast.makeText(this, "Empty Password", Toast.LENGTH_LONG).show();
        else if (editTextTextPersonName_login.getText().toString().equals(""))
            Toast.makeText(this, "Empty User Name", Toast.LENGTH_LONG).show();
        else { /* Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);*/
            // this line gets the registered name and password , in case no user was registered empty string is returned
            String input_Name = editTextTextPersonName_login.getText().toString();
            String input_password = editTextNumberPassword_login.getText().toString();

            String registeredName = preferences.getString("username", "");
            String registeredPassword = preferences.getString("password", "");

            if (input_Name.equals(registeredName) && input_password.equals(registeredPassword)) {
                Intent i_Name = new Intent(this, HomeActivity.class);
                startActivity(i_Name);
            } else {
                Toast.makeText(this, "ERROR! Username or Password not correct", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("CommitPrefEdits")
    public void Register(View view) {

        String registeredName=editTextTextPersonName_login.getText().toString();
        String registeredPassword = editTextNumberPassword_login.getText().toString();

        // saves the email value in the preferences and commits the file

        preferences.edit().putString("username", registeredName).commit();
        preferences.edit().putString("password ",registeredPassword ).commit();

        Intent i_register = new Intent(this, RegisterActivity.class);
        startActivity(i_register);
        }
    }