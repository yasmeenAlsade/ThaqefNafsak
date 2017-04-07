package com.example.yasmeen.thaqefnafsak;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends Fragment {

    RadioButton Rbutton1 , Rbutton2 , Rbutton3, Rbutton4 ;
    private TextView textView ;
    private String text  , Rt1 , Rt2 , Rt3 , Rt4 , right;
    private RadioGroup radioGroup;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    public QuestionsFragment(String txt, String Rt1 , String Rt2 , String Rt3 ,String Rt4 , String right) {
        text = txt ;
        this.Rt1 = Rt1 ;
        this.Rt2 = Rt2 ;
        this.Rt3 = Rt3 ;
        this.Rt4 = Rt4 ;
        this.right = right ;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_questions, container, false);

        textView = (TextView)view.findViewById(R.id.fragmentText) ;
        Rbutton1 =   (RadioButton)view.findViewById(R.id.first);
        Rbutton2 =   (RadioButton)view.findViewById(R.id.second);
        Rbutton3 =   (RadioButton)view.findViewById(R.id.third);
        Rbutton4 =   (RadioButton)view.findViewById(R.id.fourth);
        radioGroup = (RadioGroup) view.findViewById(R.id.radios);

        textView.setText(text);

        Rbutton1.setText(Rt1);
        Rbutton2.setText(Rt2);
        Rbutton3.setText(Rt3);
        Rbutton4.setText(Rt4);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String radiovalue = ((RadioButton)getView().findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

                if(radiovalue.equalsIgnoreCase(right))

                        Toast.makeText(getActivity().getApplicationContext() , "اجابة صحيحة", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getActivity().getApplicationContext() , "اجابة خاطئة", Toast.LENGTH_LONG).show();

            }
        });
    }
}
