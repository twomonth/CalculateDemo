package com.twomonth.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.twomonth.study.viewmodel.AtestActivity;
import com.twomonth.study.vmlivedata.BtestActivity;

public class StudyListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_list);

        findViewById(R.id.textView1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudyListActivity.this, AtestActivity.class));
            }
        });

        findViewById(R.id.textView_vmandlivedata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudyListActivity.this, BtestActivity.class));
            }
        });


    }
}
