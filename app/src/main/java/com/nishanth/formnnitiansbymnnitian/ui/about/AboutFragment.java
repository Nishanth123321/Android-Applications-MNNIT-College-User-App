package com.nishanth.formnnitiansbymnnitian.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nishanth.formnnitiansbymnnitian.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

     private ViewPager viewPager;
     private List<CourseModel> list;
     private CourseModel course;
     private ImageView college_image;
     private BranchAdapter adapter;
    private ImageView mnnitgooglemap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        list=new ArrayList<>();
        View view= inflater.inflate(R.layout.fragment_about, container, false);
        mnnitgooglemap=view.findViewById(R.id.mnnitgooglemap);
        viewPager=view.findViewById(R.id.viewPager);
        college_image=view.findViewById(R.id.college_image);
        college_image.setImageResource(R.drawable.mnnit_cmp);
        mnnitgooglemap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        addappliedmechanics();
        addbiotech();
        addchemical();
        addcivil();
        addcse();
        addelectrical();
        addece();
        addmechanical();
        addchemistry();
        addmathematics();
        addphysics();
        addmanagementstudies();
        addsocialsciences();

    adapter=new BranchAdapter(getContext(), list);
    viewPager.setAdapter(adapter);



        return view;
    }

    private void openMap() {

        Uri uri=Uri.parse("geo:25.4920, 81.8639");
        Intent intent=new Intent(Intent.ACTION_VIEW, uri);

        intent.setPackage("com.google.android.apps.maps");


        startActivity(intent);


    }

    private void addsocialsciences() {

        list.add(new CourseModel(R.drawable.socialsciences_icon, "Humanity and Social Sciences", "Department of Humanities " +
                "and social Sciences is successfully running its courses since the beginning of the Institute. " +
                "The Department has organized many short term courses " +
                "and workshops for the integrated personality development of engineering students."));
    }

    private void addmanagementstudies() {

        list.add(new CourseModel(R.drawable.physics, "Management Studies", "SMS was established in " +
                "the year 1996, with a vision to be a provider of globally competitive, technically and managerially skilled " +
                "corporate leaders " +
                "for a vibrant India, and to enrich the lives of MBA aspirants for a better foothold in the corporate world."));

    }

    private void addphysics() {

        list.add(new CourseModel(R.drawable.physics, "Physics", "The department of Physics came into existence from April, " +
                "2003. Prior to this it constituted a section of the Department of Applied " +
                "Mathematics, Applied sciences & Humanities. " +

                "The Department offers Physics courses to all branches of B.Tech. students in their first two semesters."));
    }

    private void addmathematics() {
        list.add(new CourseModel(R.drawable.maths_dept, "Mathematics", "The department of mathematics " +
                "came into existence w.e.f., 1st April, 2003, prior to this it constituted a section of the Department of " +
                "Applied Mathematics, Applied sciences & Humanities."+

                "The department offers core courses at undergraduate level and several advanced courses at post graduate level"));
    }

    private void addchemistry() {

        list.add(new CourseModel(R.drawable.chemistry_dept, "Chemistry", "The department of chemistry came " +
                "into existence w.e.f., 1st April, 2003 ,prior to this it " +
                "constituted a section of the Department of Applied Mathematics, Applied sciences & Humanities."));
    }

    private void addmechanical() {

        list.add(new CourseModel(R.drawable.ic_mech, "Mechanical", "Welcome to Mechanical " +
                "Engineering Department, Motilal Nehru National Institute of Technology (MNNIT) Allahabad, " +
                "Prayagraj, Uttar Pradesh, India. We are the largest community of excellent, energetic, and dynamic faculty, staff and " +
                "students in the institute. The department is one of the oldest as it started in year 1961"));
    }

    private void addece() {

        list.add(new CourseModel(R.drawable.ece_icon, "ECE", " The Electrical Engineering " +
                "Department came into existence in the year 1961, with the objective to produce technical man power of high quality and promote research and development activity. With a modest beginning of introducing four year Bachelor of Engineering (BE) degree programme in \n" +
                "    1961, a post graduate programme in Electrical Machine / Power System / Control " +
                "System was introduced in the year 1970-71."));

    }

    private void addelectrical() {

        list.add(new CourseModel(R.drawable.electrical_icon, "Electrical", " The Electrical Engineering " +
                "Department came into existence in the year 1961, with the objective to produce technical man power of high quality and promote research and development activity. With a modest beginning of introducing four year Bachelor of Engineering (BE) degree programme in \n" +
                "    1961, a post graduate programme in Electrical Machine / Power System / Control " +
                "System was introduced in the year 1970-71."));


    }

    private void addcse() {

        list.add(new CourseModel(R.drawable.ic_cse, "CSE", "MNNIT Allahabad takes the pride in taking a " +
                "lead role to start the first B.Tech Computer Science and Engineering program of the country in 1977 under " +
                "Electrical Engineering department with a modest strength of 10 students."));
    }

    private void addcivil() {

        list.add(new CourseModel(R.drawable.civil_icon, "Civil Engineering", "The Civil Engineering Department offers " +
                "a Bachelor Of Technology and three regular post graduate courses in Structural, Environmental and " +
                "Geotechnical Engineering. It also offers a highly " +
                "sought after part-time course for in-service engineers in Computer Aided Design in Civil Engineering."));
    }

    private void addchemical() {

        list.add(new CourseModel(R.drawable.chemical_icon, "Chemical Engineering", "The chemical engineering department " +
                "strives to impart high quality technical education with a fine balance of fundamental knowledge, practical " +
                "exposure and novel concepts. We believe in providing our students with an education that combines conceptual " +
                "learning and the excitement of discovery with the support and intellectual " +
                "stimulation of a diverse campus community."));
    }

    private void addbiotech() {

        list.add(new CourseModel(R.drawable.biotech, "BioTechnology", "Biotechnology at MNNIT Allahabad " +
                "was established as a new academic unit under Applied Mechanics in 2006, with the objective of integrating life " +
                "sciences with engineering and to develop " +
                "cutting-edge technology through research, training and technological innovation."));

    }

    private void addappliedmechanics() {

        
        list.add(new CourseModel(R.drawable.applied_mechanics, "Applied Mechanics", "The Department of Applied Mechanics is established in 1965. It was initially named as 'Department of Applied Mechanics, Hydraulic and Hydraulic Machines', which was replaced by new name 'Applied Mechanics Department' in 2003."));
    }
}