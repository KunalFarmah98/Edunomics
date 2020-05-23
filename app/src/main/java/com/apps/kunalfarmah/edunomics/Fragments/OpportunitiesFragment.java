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
public class OpportunitiesFragment extends Fragment {

    public OpportunitiesFragment() {
        // Required empty public constructor
    }

    RecyclerView rv;
    DataAdapter  madapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_opportunities, container, false);

        rv = v.findViewById(R.id.recycler);
        /**
         *  creating adapter list here, Ideally it should me made in a viewmodel and fetched via api
         **/
        bildAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(madapter);
        return v;
    }
    void bildAdapter(){
        ArrayList<DataModel> data = new ArrayList<>();
        data.add(new DataModel(getResources().getDrawable(R.drawable.proferssor),
                "Industry Expert As Professor",
                "Real World Buisness/Technical Learning, as well as there is evident gap of qualified good professors also." +
                        " Get connected with them to get knowledge."));
        data.add(new DataModel(getResources().getDrawable(R.drawable.next),
                "Why & What is best for me Next",
                "We all do have dreams, and to achieve them we needs to be very clear about what need to be done next. " +
                        "And sometime we even need handholding for How?"));

        madapter = new DataAdapter(getContext(),data,"opportunities");

    }
}
