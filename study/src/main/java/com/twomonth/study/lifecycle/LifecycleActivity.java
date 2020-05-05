package com.twomonth.study.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.twomonth.study.R;

/**
 *
 * @ProjectName:
 * @Package:        com.twomonth.study.lifecycle
 * @ClassName:      LifecycleActivity
 * @Author:         wjc
 * @CreateDate:     2020/5/5 2:50 PM
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/5/5 2:50 PM
 * @UpdateRemark:   更新内容
 * @Version:        1.0
 * @Description:
 */

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        getLifecycle().addObserver(new LifecycleForThis(LifecycleActivity.class.getName()));
    }
}
