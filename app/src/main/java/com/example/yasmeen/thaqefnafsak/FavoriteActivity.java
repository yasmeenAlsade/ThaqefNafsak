package com.example.yasmeen.thaqefnafsak;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class FavoriteActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private ListView listView_allInfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        listView_allInfo = (ListView)findViewById(R.id.listView) ;
        final SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        final Map<String, ?> keys = prefs.getAll();

        final ArrayList<String> info = new ArrayList<String>() ;

        for (Map.Entry<String, ?> entry : keys.entrySet()) {

            info.add(entry.getValue().toString());

        }
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this , R.layout.my_text_view , info) ;

        listView_allInfo.setAdapter(arrayAdapter);

        listView_allInfo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(FavoriteActivity.this);
                adb.setTitle("حذف ؟") ;
                adb.setMessage("هل تريد حذف هذه المعلومة ؟") ;
                final int positionToRemove = position;
                adb.setNegativeButton("لا", null);
                adb.setPositiveButton("نعم", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                        for (Map.Entry<String, ?> entry : keys.entrySet()) {

                            if (entry.getValue().equals(info.get(positionToRemove).toString())) {
                                preferences.edit().remove(entry.getKey()).commit();
                            }

                        }
                        info.remove(positionToRemove);
                        arrayAdapter.notifyDataSetChanged();
                    }});
                adb.show();
                return true;
            }
        });

    }

}
