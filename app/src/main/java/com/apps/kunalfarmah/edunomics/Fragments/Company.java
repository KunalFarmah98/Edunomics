package com.apps.kunalfarmah.edunomics.Fragments;

import android.os.Bundle;

import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.kunalfarmah.edunomics.Adapters.FAQAdapter;
import com.apps.kunalfarmah.edunomics.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Company extends Fragment {

    public Company() {
        // Required empty public constructor
    }

    RecyclerView rv;
    FAQAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_company, container, false);

        rv = v.findViewById(R.id.recycler);
        buildAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(mAdapter);
        return v;
    }


    void buildAdapter(){
        ArrayList<Pair<String,String>> data = new ArrayList<>();

        data.add(new Pair<String, String>("Is there a cost to hire students from edunomics?",
                "No. We are completely open sourced. We just emphasis on the companies to give the best in the market packages for our students, since they are of the utmost quality and talent"));

        data.add(new Pair<String, String>("What skills do EDUNOMICS help with?",
                "Edunomics provides a workforce of different skills that in any way work innovatively and productively in with quality service and outputs. Here we concentrate on giving the best and latest tech industry related skills and knowledge by training them in Web Technology (HTML,CSS,Bootstrap,ReactJS,MySQL and NodeJS) and Mobile Application Development (Android and ReactNative)."));

        data.add(new Pair<String, String>("How do you select students for your program on your platform?",
                "We differentiate on the basis of a three-step test process,which tests his/her abilities, willingness to work and aptitude.Firstly, the students have to apply with an insightful questionnaire cum submission form and then interact with our ALPHA Bot which gives them the in depth analysis and mentors them to what they are really good at. Further they are appointed tasks in a well thought and planned challenge, upon the successful completion of the challenge we select them."));
        data.add(new Pair<String, String>("How are you different from other learning platforms and bootcamops?",
                "Finding and hunting the right talent in students and then helping them with it to pursue what they really love is a strategy we acquire at EDUNOMICS. We give emphasis to training them with industry experts and not just teachers or professors, building a bridge between industry and academics. Being totally open sourced we ensure the availability of smart, talented and sincere candidates with skill optimum experience. We are a productive platform for industries providing new facilities and innovation peak for quality Services and output. Thus, helping in increasing the competitiveness in favor of industry."));
        data.add(new Pair<String, String>("Is EDUNOMICS a hiring agency as well?",
                "Yes, Edunomics is a hiring agency as well. It provides both Internships and Jobs to most deserved candidates not only from outside the world but also to the talented and sincere learners who are the part of Edunomics. Edunomics hire Professors, teachers, content writers, content editors, sales and accounts managers, etc. Providing them with good salaries and stipends. Moreover, the benefits of Certification are also provided to the candidates engaged in internships."));
        data.add(new Pair<String, String>("What is the salary of an edunomics graduate?",
                "EDUNOMICS graduates can get a salary that of any top graduates depending upon the programs, Skills set, skill optimum experiences, and many other factors. Because their developed real-world industrial skills are what matters and are accredited the most."));
        data.add(new Pair<String, String>("What if there is an issue with an EDUNOMICS hire?",
                "Our active support team is always there to look and resolve any issues if they may arise to the best of both the parties/’s needs. Edunomics gives quick responses on such a situation and makes sure that not either of the parties never gets affected by it in any way. However, our strategic system is tried and tested, issue free, and paved in such a way that it works for the smooth functioning of students and industry experts."));

        mAdapter = new FAQAdapter(getContext(),data);
    }
}
