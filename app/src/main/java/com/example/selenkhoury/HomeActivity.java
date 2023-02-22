package com.example.selenkhoury;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    EditText editTextNumber1, editTextNumber2;
    Button buttonMinus, buttonPlus;
    TextView textView_Result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // linking objects with design by id (بربط الديزاين مع الجافا )
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        textView_Result = findViewById(R.id.textView_Result);

    }

    public void Plus(View view) {
        if (editTextNumber1.getText().toString().equals(""))
            Toast.makeText(this,"NO RESULT",Toast.LENGTH_LONG).show();
        else if (editTextNumber2.getText().toString().equals(""))
            Toast.makeText(this,"NO RESULT",Toast.LENGTH_LONG).show();
        else{
            double number1 = Double.parseDouble(editTextNumber1.getText().toString());
            double number2 = Double.parseDouble(editTextNumber2.getText().toString());
            textView_Result.setText((number1+number2)+"");}

    }

    public void Minus(View view) {
        if (editTextNumber1.getText().toString().equals(""))
            Toast.makeText(this,"NO RESULT",Toast.LENGTH_LONG).show();
        else if (editTextNumber2.getText().toString().equals(""))
            Toast.makeText(this,"NO RESULT",Toast.LENGTH_LONG).show();
        else{
            double number1 = Double.parseDouble(editTextNumber1.getText().toString());
            double number2 = Double.parseDouble(editTextNumber2.getText().toString());
            textView_Result.setText((number1-number2)+"");}

    }


}