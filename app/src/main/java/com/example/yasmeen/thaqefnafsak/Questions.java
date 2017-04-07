package com.example.yasmeen.thaqefnafsak;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Questions extends AppCompatActivity {

    ViewPager viewPager ;
    DBHelper dbHelper = new DBHelper(this) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager()));


    }


    public class CustomAdapter extends FragmentPagerAdapter {
        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            String[] arr = dbHelper.getAllData2().get(position).getAnswers().split(" ") ;

            QuestionsFragment questionsFragment = new QuestionsFragment(dbHelper.getAllData2().get(position).getQuestions() , arr[0] , arr[1],arr[2] , arr[3] ,dbHelper.getAllData2().get(position).getRight() ) ;
            //info = dbHelper.getAllData().get(position).getInfo() ;
            //Toast.makeText(getApplicationContext() , info , Toast.LENGTH_LONG).show() ;
            return questionsFragment ;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
