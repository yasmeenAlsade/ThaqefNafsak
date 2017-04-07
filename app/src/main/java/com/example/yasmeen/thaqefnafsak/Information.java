package com.example.yasmeen.thaqefnafsak;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Information extends AppCompatActivity {

    private Button circleButton ;
    ViewPager viewPager ;
    private Toolbar toolbar;
    DBHelper dbHelper = new DBHelper(this) ;
    public static final String MY_PREFS_NAME = "MyPrefsFile";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager()));

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        circleButton = (Button) findViewById(R.id.circle_button) ;

        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Information.this , FavoriteActivity.class) ;
                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu , menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.main_menu :
                shareIt() ;
                break ;
            case R.id.main_menu2 : {
                //Toast.makeText(this , info , Toast.LENGTH_LONG).show() ;
                int position = viewPager.getCurrentItem() ;
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("info" + position ,dbHelper.getAllData().get(position).getInfo() ) ;
                editor.commit();
               // Toast.makeText(getApplicationContext() ,dbHelper.getAllData().get(position).getInfo() , Toast.LENGTH_LONG).show() ;
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent();
        sharingIntent.setAction(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, " www.aauj.edu/?q=ar");
        startActivity(Intent.createChooser(sharingIntent, "مشاركة التطبيق بواسطة"));
    }


    public class CustomAdapter extends FragmentPagerAdapter{
        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            InfoFragment infoFragment = new InfoFragment(dbHelper.getAllData().get(position).getInfo()) ;
            //info = dbHelper.getAllData().get(position).getInfo() ;
            //Toast.makeText(getApplicationContext() , info , Toast.LENGTH_LONG).show() ;
            return infoFragment ;
        }

        @Override
        public int getCount() {
            return 10;
        }
    }
}



