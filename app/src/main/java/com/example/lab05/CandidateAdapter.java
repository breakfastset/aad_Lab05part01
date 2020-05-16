package com.example.lab05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CandidateAdapter extends ArrayAdapter<Candidate> {

    private int resource;
    private ArrayList<Candidate> candidates;
    private Context context;

    public CandidateAdapter(@NonNull Context context, int resource,
                            @NonNull ArrayList<Candidate> candidates) {
        super(context, resource, candidates);
        this.resource = resource;
        this.candidates = candidates;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        try {
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(resource, parent, false);
            }
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textViewName = view.findViewById(R.id.textViewName);
            TextView textViewDetail = view.findViewById(R.id.textViewDetail);

            imageView.setImageResource(candidates.get(position).getPhoto());
            textViewName.setText(candidates.get(position).getName());
            textViewDetail.setText(candidates.get(position).getDetail());



        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return view;
    }
}
