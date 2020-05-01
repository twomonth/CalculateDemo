package com.twomonth.study.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.twomonth.study.R;

public class AtestActivity extends AppCompatActivity {

    TextView textView;
    AviewModel aviewModel;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atest_view_model);

        aviewModel = ViewModelProviders.of(this).get(AviewModel.class);
        textView = findViewById(R.id.textView_a);
        textView.setText(String.valueOf(aviewModel.getNum()));


        findViewById(R.id.button_jia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aviewModel.setNum(aviewModel.getNum()+1);
                textView.setText(String.valueOf(aviewModel.getNum()));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aviewModel.setNum(aviewModel.getNum()-1);
                textView.setText(String.valueOf(aviewModel.getNum()));
            }
        });
    }
}
