package com.apps.kunalfarmah.edunomics.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.kunalfarmah.edunomics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitiativesFragment extends Fragment {

    public InitiativesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_initiatives, container, false);
    }
}
