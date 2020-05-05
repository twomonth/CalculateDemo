package com.twomonth.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.twomonth.study.lifecycle.LifecycleActivity;
import com.twomonth.study.livedata.LiveDataActivity;

public class StudyListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_list);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudyListActivity.this, LifecycleActivity.class));
            }
        });

        findViewById(R.id.button_livedata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudyListActivity.this, LiveDataActivity.class));
            }
        });
    }
}
