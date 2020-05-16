package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhotoListActivity extends AppCompatActivity {

    private ListView listView;
    private String[] candidateNames;
    private String[] candidateDetails;

    public static int[] candidatePhotos = {
            R.drawable.clinton,
            R.drawable.sanders,
            R.drawable.omalley,
            R.drawable.chafee,
            R.drawable.trump,
            R.drawable.carson,
            R.drawable.rubio,
            R.drawable.bush,
            R.drawable.shinjiko,
            R.drawable.moroboshi
    };

    private ArrayList<Candidate> candidateArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        candidateNames = getResources().getStringArray(R.array.candidateNames);
        candidateDetails = getResources().getStringArray(R.array.candidateDetails);

        generateCandidates();  // prepare the arrayList for adapter

        // refer to the listView to prepare for population
        listView = findViewById(R.id.listViewComplex);

        // Create the adapter to connect to the data (candidateArrayList)
        CandidateAdapter candidateAdapter = new CandidateAdapter(this, R.layout.list_item, candidateArrayList);

        // connect the adapter to the listView to populate the listView
        listView.setAdapter(candidateAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getBaseContext(), "You clicked " +
                                candidateArrayList.get(position), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void generateCandidates() {
        for (int i = 0; i < candidatePhotos.length; i++) {
            candidateArrayList.add(
                    new Candidate(candidateNames[i],
                            candidateDetails[i],
                            candidatePhotos[i])
            );
        }
    }
}
