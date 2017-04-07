package com.example.yasmeen.thaqefnafsak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button infoBtn ;
    private Button quesBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getApplicationContext().deleteDatabase("my_db") ; // delete the database :D

        infoBtn = (Button)findViewById(R.id.button);
        quesBtn =  (Button)findViewById(R.id.button2);

        quesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this , Questions.class) ;
                startActivity(intent);
                }

        });


        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Information.class) ;
                startActivity(intent);
            }
        });

    }





}
