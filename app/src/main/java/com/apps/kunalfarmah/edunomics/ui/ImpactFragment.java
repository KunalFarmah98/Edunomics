package com.apps.kunalfarmah.edunomics.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.kunalfarmah.edunomics.DataAdapter;
import com.apps.kunalfarmah.edunomics.DataModel;
import com.apps.kunalfarmah.edunomics.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImpactFragment extends Fragment {

    public ImpactFragment() {
        // Required empty public constructor
    }

    RecyclerView rv;
    DataAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_impact, container, false);
        rv = v.findViewById(R.id.recycler);

        // creating adapter list here, Ideally it should me made in a viewmodel and fetched via api
        buildAdapter();
        rv.setLayoutManager(new GridLayoutManager(getContext(),2));
        rv.setAdapter(mAdapter);

        return v;
    }

    void buildAdapter(){
        ArrayList<DataModel>data = new ArrayList<>();
        data.add(new DataModel(getResources().getDrawable(R.drawable.education),"Quality Education",
                "Skills with optimum experience will be shared to make a great transition to a professional world."));
        data.add(new DataModel(getResources().getDrawable(R.drawable.talent),"Better Talent",
                "Once the availability of Smart and sincere talent is ample, the increase in competition will be in favour of industry too."));
        data.add(new DataModel(getResources().getDrawable(R.drawable.productivity),"Productivity at jobs",
                "Talented workforce will enable innovation and productivity led mission for quality output."));
        data.add(new DataModel(getResources().getDrawable(R.drawable.innovation),"Innovation Drive",
                "Further industry will innovate to claim the value available with more demand & hence more talented people."));
        data.add(new DataModel(getResources().getDrawable(R.drawable.proffits),"More Profits",
                "When productivity is more and rejections are less,it will lead to more sales and profits."));
        data.add(new DataModel(getResources().getDrawable(R.drawable.capacity),"Need Capacity Enhancement",
                "Invite opportunity for Existing & New industry to come up with new facilities."));
        data.add(new DataModel(getResources().getDrawable(R.drawable.jobs),"More Jobs",
                "As consumption, industry and innovation peaks will also lead to increasing number of jobs and hence create a circle."));

        mAdapter = new DataAdapter(getContext(),data,"impact");
    }
}
