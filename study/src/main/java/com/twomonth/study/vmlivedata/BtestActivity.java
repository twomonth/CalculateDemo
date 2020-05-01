package com.twomonth.study.vmlivedata;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProviders;

import com.twomonth.study.R;
import com.twomonth.study.viewmodel.AviewModel;

public class BtestActivity extends AppCompatActivity {

    TextView textView;
    BviewModelLiveData bviewModelLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atest_view_model);

        textView = findViewById(R.id.textView_a);
        bviewModelLiveData = ViewModelProviders.of(this).get(BviewModelLiveData.class);
        textView.setText(String.valueOf(bviewModelLiveData.getNumber()));
        bviewModelLiveData.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });
        findViewById(R.id.button_jia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bviewModelLiveData.add(1);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bviewModelLiveData.jian(1);
            }
        });

         /**
          * @method  onCreate
          * @date: 2020/5/1 1:09 PM
          * @author: wjc
          * @param [savedInstanceState]
          * @return void
          * @description 长久保存数据使用 SavedStateHandle,代替原来在activity中使用 onSaveInstanceState
          */
        CviewModelLiveData cviewModelLiveData = ViewModelProviders
                .of(this,new SavedStateViewModelFactory(getApplication(),this))
                .get(CviewModelLiveData.class);
    }

}
