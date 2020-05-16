package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] candidateNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // populate the list of candidate names from the strings.xml array
        candidateNames = getResources().getStringArray(R.array.candidateNames);

        // to refer to the listViewSimple container in activity_main.xml
        listView = findViewById(R.id.listViewSimple);

        // Create the adapter so that we can connect to the data source - candidateNames
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, candidateNames);

        // Connect to the adapter
        listView.setAdapter(arrayAdapter);

        // Make the listView respond to the clicks
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(getBaseContext(), candidateNames[position]
                                        + " seriously?", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }

    public void onComplexListClick(View view) {
        startActivity(new Intent(this, PhotoListActivity.class));
    }
}
