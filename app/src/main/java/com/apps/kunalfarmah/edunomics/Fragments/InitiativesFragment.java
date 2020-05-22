package com.apps.kunalfarmah.edunomics.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.kunalfarmah.edunomics.Adapters.DataAdapter;
import com.apps.kunalfarmah.edunomics.Models.DataModel;
import com.apps.kunalfarmah.edunomics.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitiativesFragment extends Fragment {

    public InitiativesFragment() {
        // Required empty public constructor
    }

    RecyclerView rv;
    DataAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_initiatives, container, false);
        rv = v.findViewById(R.id.recycler);

        // creating adapter list here, Ideally it should me made in a viewmodel and fetched via api
        buildAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(mAdapter);

        return v;
    }

    void buildAdapter(){
        ArrayList<DataModel> data = new ArrayList<>();
        data.add(new DataModel(getResources().getDrawable(R.drawable.initiatives),
                "","Scouting 50 of the aspiring minds, willing to achieve excellence." +
                "An initiative to provide world-class training to 50 talented students with serious " +
                "aspirations to achieve their goal of success to work in challenging environment and " +
                "grow fast"));
        data.add(new DataModel(getResources().getDrawable(R.drawable.wenestor),
                "Wenestor","Get help on improving your business scenario right from purchase to Marketing."));
        mAdapter = new DataAdapter(getContext(),data,"initiatives");

    }
}
