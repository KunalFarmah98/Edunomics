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
public class Student extends Fragment {

    public Student() {
        // Required empty public constructor
    }

    RecyclerView rv;
    FAQAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_student, container, false);

        rv = v.findViewById(R.id.recycler);
        buildAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(mAdapter);
        return v;
    }

    void buildAdapter(){
        ArrayList<Pair<String,String>> data = new ArrayList<>();
        data.add(new Pair<String, String>("How does Edunomics work?",
                "We at edunomics basically combine technological expertise with business intelligence" +
                " and deliver it to those who are in need, connecting the students with real world " +
                "industry experts who will give the right training and development needed with accordance " +
                "to the real world experiences. Edunomics works by providing online textbook depositories, " +
                "helps to develop and exercise skills by providing different courses of their domain of " +
                "interest. Differentiated lessons along with diagnostic tools we are completely open sourced."));
        data.add(new Pair<String, String>("Who is Edunomics for?",
                "This platform is for hardcore enthusiasts who are eager to go through intensive extroverted teaching and learning process more closely related to their specific industry rather than theorotical, along with their batch of similar aspiring students to have a well interacted expert-student and student-student interactions. Edunomics belongs to every Student and Professor who wishes to benefit the human resource as a whole. Students who wish to empower themselves with the skill of knowledge, along with Professors interested in providing quality education to those in need, both have a place at Edunomics."));

        data.add(new Pair<String, String>("How much is the fee?",
                "No Fee. We consider education to be the most essential part that everyone should be obligated to. Therefore, we are completely Open Sourced."));
        data.add(new Pair<String, String>("Is there any security deposit?",
                "No.We don't take any amount or any kind of deposit from our users."));
        data.add(new Pair<String, String>("What happens if I quit the program? Do I still have to pay?",
                "If you quit the program, you will miss out on a certificate of completion that we will be presenting to every student who successfully has finished the particular program. Anyways, we are 100% open sourced so we never ask any user for any payments."));
        data.add(new Pair<String, String>("In what scenarios is the security deposit not refunded?",
                "We don't obtain any sort of deposit from our students or professors."));
        data.add(new Pair<String, String>("Do I have to accept my offer from hiring partners??",
                "Not necessarily, you can always choose to decline the offer according to the best of your wishes. However, do realize that Edunomics plays a vital role in the hiring process by referring to the companies with the best, talented and the most innovative workforce."));
        mAdapter = new FAQAdapter(getContext(),data);

    }
}
