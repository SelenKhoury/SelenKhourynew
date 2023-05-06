package com.example.selenkhoury;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView.findViewById(R.id.listView);
        /*
        listView = (ListView) findViewById(R.id.listView);
         */

        //make an array list
        ArrayList<String> arrayList = new ArrayList<>();

        // add items to arrayList
        arrayList.add("Banana");
        arrayList.add("Apple");

        //initialize the adapter אתחול המקשר (המקשר לוקח מהאייטמז שבאראי ליסט ושם אותם בליסט שבדיזין)
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        //connect adapter to array عملنالو سيت عشان يوخد من الاري ويحط بالليست
        listView.setAdapter(arrayAdapter);

        //handle item clicks (כשמקישים על בננה או תוח או אייטם בליסט לה קורה)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListActivity.this, "clicked item" +i+ " "+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}