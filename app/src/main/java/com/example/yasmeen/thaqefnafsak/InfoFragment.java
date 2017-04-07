package com.example.yasmeen.thaqefnafsak;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {


    private  TextView  textView ;
    private String text ;
    protected View mView;


    public InfoFragment() {
        // Required empty public constructor
    }
    public InfoFragment(String txt) {
      text = txt ;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);
        textView = (TextView)view.findViewById(R.id.fragmentText) ;

        textView.setText(text);
        // Inflate the layout for this fragment

        mView = view ;
        return view ;
    }

    public  String getText() {
       TextView textView = (TextView)mView.findViewById(R.id.fragmentText) ;
        return (String) textView.getText();
    }
}
