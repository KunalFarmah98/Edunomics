package com.apps.kunalfarmah.edunomics.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.apps.kunalfarmah.edunomics.Adapters.BlogAdapter;
import com.apps.kunalfarmah.edunomics.Models.BlogModel;
import com.apps.kunalfarmah.edunomics.R;

import java.util.ArrayList;
import java.util.List;

public class BlogActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecyclerView rv;
    BlogAdapter mAdapter;
    Spinner spinner;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        /**
         * Setting Edunomics Logo in Action Bar
         **/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(actionBar.getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(actionBar.getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.logo);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT
                | Gravity.CENTER_VERTICAL);
        layoutParams.rightMargin = 40;
        imageView.setLayoutParams(layoutParams);
        actionBar.setCustomView(imageView);

        rv = findViewById(R.id.recycler);
        spinner = findViewById(R.id.category);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        // More can be added with time, currently only one exists
        List<String> categories = new ArrayList<String>();
        categories.add("All Available Categories");
        categories.add("Web Development");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        /** ALL THIS DATA MUT BE FETCHED VIA API IN A VIEWMODEL FOLLOWING THE MVVM ARCHITECTURE
         * BUT HARD CODING IT HERE FOR SIMPLICITY AND NOT USING MVVM TO PREVENT UNNECESSARY CLASS
         * CREATION AS I WON'T USE IT AS API IS NOT DEFINED.
         **/
        buildAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void buildAdapter() {
        ArrayList<BlogModel> data = new ArrayList<>();
        ArrayList<String> links = new ArrayList<>();
        links.add("https://youtu.be/Q8TXgCzxEnw");
        links.add("https://youtu.be/Q8TXgCzxEnw");
        data.add(new BlogModel(getResources().getDrawable(R.drawable.blog), "How to Learn ReactJS", "Posted on Sun May 10 2020", "ReactJS BLOG", "React is great at displaying your data in a hierarchical component view. But how do your components get the data? There are many ways to go about it, each with their own pros and cons. In this article, I’ll cover all the major ways to do so, as well as their various alternatives, with hands-on examples. When you’re done reading, you’ll have a clear understanding of the big picture of data fetching. You’ll be able to decide which approaches are the best fit for your application and have some code samples to build upon. The full source code isData fetching, setting up a subscription, and manually changing the DOM in React components are all examples of side-effects.", links));
        links.clear();
        links.add("https://youtu.be/Q8TXgCzxEnw");
        links.add("https://youtu.be/Q8TXgCzxEnw");
        data.add(new BlogModel(getResources().getDrawable(R.drawable.blog), "Web dev2", "Posted on Sun May 10 2020", "Web Dev BLOG", "React is great at displaying your data in a hierarchical component view. But how do your components get the data? There are many ways to go about it, each with their own pros and cons. In this article, I’ll cover all the major ways to do so, as well as their various alternatives, with hands-on examples. When you’re done reading, you’ll have a clear understanding of the big picture of data fetching. You’ll be able to decide which approaches are the best fit for your application and have some code samples to build upon. The full source code isData fetching, setting up a subscription, and manually changing the DOM in React components are all examples of side-effects.", links));

        mAdapter = new BlogAdapter(this, data, "blogs");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        /** A method of ViewModel would be called here to change the adapter contents using MVVM Architecture
         * and only load blogs of that categories
         * Currently hardcoded as only one category is available.
         **/
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        String item = "All";
        /** A method of ViewModel would be called here to change the adapter contents using MVVM Architecture
         *  and load all blogs for all categories.
         *  Currently hardcoded as only one category is available.
         **/
    }
}
