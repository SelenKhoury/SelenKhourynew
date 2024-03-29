package com.example.selenkhoury;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private EditText editTextEmailAddress, editTextPassword;// editTextPersonName;
    private final String valid_mail = "admin";
    private final String valid_password = "1";
    private Button button_enter;

    SharedPreferences preferences;

    ArrayList<FoodTModel> foodTModels = new ArrayList<>();

    int[] foodImages = {R.drawable.greece,R.drawable.chinese,R.drawable.france,R.drawable.israel,R.drawable.japanese,R.drawable.italy,R.drawable.mexico};

    /* EditText editTextEmailAddress, editTextPassword, editTextPersonName;
    Button buttonLogin, buttonRegister;
  */

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  editTextEmailAddress = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPersonName = findViewById(R.id.editTextPersonName);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);
        textView = findViewById(R.id.textView);
        textView_signup = findViewById(R.id.textView_signup); */
        button_enter = findViewById(R.id.button_enter);

        Intent notification = new Intent(this, Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, notification, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 3000, pendingIntent);

        // creates a preferences file ,
        preferences = getSharedPreferences("Userinfo", 0);

/*
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setUpFoodModels();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, foodTModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpFoodModels(){
        String[] foodNames = getResources().getStringArray(R.array.food_full_txt);

        for (int i = 0; i<foodNames.length;i++){
            foodTModels.add(new FoodTModel(foodNames[i],foodImages[i]));
        }
*/
    }

    // OnCreate

    //load option menu from an activity (linking xml option menu with the java activity)
    /*
    this method loads the menu design into this activity
     */
    //load option menu from an activity (linking xml option menu with the java activity)
    /*
    this method loads the menu design into this activity
     */
    //

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return true;
    }


    public void entering(View view) {
        Toast.makeText(MainActivity.this, "main menu clicked", Toast.LENGTH_SHORT).show();
        Intent intent_main = new Intent(this, MainActivity2.class);
        startActivity(intent_main);
    }

    //פונקציה שמגדירה את הקליקים
    //handle options menu click events
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Person:
                {Toast.makeText(MainActivity.this, "Log in clicked", Toast.LENGTH_SHORT).show();
                    Intent x = new Intent(this, LogInActivity.class);
                    startActivity(x);
                    break;}
           /* case R.id.search: {
                break;}*/
            case R.id.settings_menu:
                Toast.makeText(MainActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help_menu: {
                Toast.makeText(MainActivity.this, "Help clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, HelpActivity.class);
                startActivity(i);
                break;}
            case R.id.MyProfile_menu:{
                Toast.makeText(MainActivity.this, "My Profile clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, UserProfileActivity.class);
                startActivity(i);
                break;}
            case R.id.logout_menu:
                Toast.makeText(MainActivity.this, "LogOut clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_menu:
                Toast.makeText(MainActivity.this, "About clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_menu: {
                Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(this, MainActivity.class);
                startActivity(j);
                break;
            }
            case R.id.list_menu: {
                Toast.makeText(MainActivity.this, "list clicked", Toast.LENGTH_SHORT).show();
                Intent x = new Intent(this, ListActivity.class);
                startActivity(x);
                break;
            }
        }
        return true;
    }
    /* another method - if :
     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      //in case user chose settings menu
       if (item.getItemId()== R.id.about_menu){
       // open the about activity when the about menu item selected
       // this is from where , and the second parameter is to where
          Intent i = new Intent(this, AboutActivity.class);
          startActivity(i);
           }
       else if (item.getItemId()== R.id.settings_menu){
     }
     return true;
     }
     */

    /*
    is called when the user clicks back button
     */
    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Back Button Was Pressed ! ");
        dialog.setMessage("Are You Sure You Want To Exit ?");
        // in case the user chose No , Nothing happens, the dialog closes
        dialog.setNegativeButton("No ", null);
        // when the user clicks on Yes button , the application closes
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        // בניית האייקון
        dialog.setIcon(R.drawable.ic_baseline_emoji_people_24);
        //  בניית הדיאלוג
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        //alertdialog - name of the object
    }

    /*
    public void Login(View view) {
        /*if (editTextEmailAddress.getText().toString().equals(""))
            Toast.makeText(this,"Empty Email",Toast.LENGTH_LONG).show();
        else if (editTextPassword.getText().toString().equals(""))
            Toast.makeText(this,"Empty Password",Toast.LENGTH_LONG).show();
        else if (editTextPersonName.getText().toString().equals(""))
            Toast.makeText(this,"Empty User Name",Toast.LENGTH_LONG).show();
        else {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }
        // this line gets the registered email and password , in case no user was registered empty string is returned
        String input_mail =editTextEmailAddress.getText().toString();
        String input_password = editTextPassword.getText().toString();

        String registeredMail = preferences.getString("email","");
        String registeredPassword = preferences.getString("password","");

        if (input_mail.equals(registeredMail) && input_password.equals(registeredPassword)){
            Intent i_mail = new Intent(this,HomeActivity.class);
            startActivity(i_mail);}
        else {
            Toast.makeText(this,"ERROR! Email or Password not correct",Toast.LENGTH_SHORT).show();
        }}
    @SuppressLint("CommitPrefEdits")*/
    /*public void Register(View view) {

        String registeredMail =editTextEmailAddress.getText().toString();
        String registeredPassword = editTextPassword.getText().toString();

        // saves the email value in the preferences and commits the file

        preferences.edit().putString("email", registeredMail).commit();
        preferences.edit().putString("password ",registeredPassword ).commit();

        Intent i_register = new Intent(this, RegisterActivity.class);
        startActivity(i_register);
    }*/
}