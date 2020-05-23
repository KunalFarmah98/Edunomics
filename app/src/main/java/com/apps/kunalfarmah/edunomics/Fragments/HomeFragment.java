package com.apps.kunalfarmah.edunomics.Fragments;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import android.widget.Toast;

import com.apps.kunalfarmah.edunomics.R;


public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    Button career, skill, search;
    String choice = "CAREER", query = "";
    AutoCompleteTextView et;

    ArrayAdapter<String> adapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        career = v.findViewById(R.id.career);
        skill = v.findViewById(R.id.skill);
        search = v.findViewById(R.id.search);

        skill.setAlpha(0.3f);

        /**  Ideally an AI algorithm or ML model must be used to build autocomplete suggestions
         APIs like Google Place can be used but it out of context of this app
         Hence I have compiled a list of all countries (for economics) and companies (for education)
         in the world to help autocomplete along with some common words in educational institutions.
         **/
        buildAutoCompleteAdapter();

        et = v.findViewById(R.id.autoCompleteTextView);
        et.setThreshold(1);//will start working from first character
        et.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        et.setTextColor(Color.BLACK);


        career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (career.getAlpha() != 1f)
                    career.setAlpha(1f);
                if (skill.getAlpha() == 1f)
                    skill.setAlpha(0.3f);
                choice = "CAREER";
            }
        });
        skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (career.getAlpha() == 1f)
                    career.setAlpha(0.3f);
                if (skill.getAlpha() != 1f)
                    skill.setAlpha(1f);
                choice = "SKILL";
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query = et.getText().toString();
                Toast.makeText(getContext(),
                        "Will Search for " + query + " under " + choice + " over api or website url. "
                        , Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }

    void buildAutoCompleteAdapter() {
        String[] filter = getResources().getStringArray(R.array.Countires_Comapnies);


        adapter = new ArrayAdapter<String>
                (getContext(), android.R.layout.select_dialog_item, filter);

    }
}
