package com.apps.kunalfarmah.edunomics.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.kunalfarmah.edunomics.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }
    Button career,skill,search;
    String choice="CAREER",query="";
    EditText et;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_home, container, false);
        career = v.findViewById(R.id.career);
        skill = v.findViewById(R.id.skill);
        search = v.findViewById(R.id.search);
        et = v.findViewById(R.id.query);
        query = et.getText().toString();
        skill.setAlpha(0.3f);


        career.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(career.getAlpha()!=1f)
                career.setAlpha(1f);
                if(skill.getAlpha()==1f)
                skill.setAlpha(0.3f);
                choice="CAREER";
            }
        });
        skill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(career.getAlpha()==1f)
                career.setAlpha(0.3f);
                if(skill.getAlpha()!=1f)
                skill.setAlpha(1f);
                choice="SKILL";
            }
        });

        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    et.setHint("");
                else
                    et.setHint("Enter Your Query");
            }
        });



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),
                        "Will Search for "+et.getText().toString()+" under "+choice+" over api or website url. "
                        ,Toast.LENGTH_SHORT).show();
            }
        });
        return v;

    }
}
