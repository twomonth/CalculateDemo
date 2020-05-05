package com.twomonth.study.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.twomonth.study.R;

public class LiveDataActivity extends AppCompatActivity {

    ImageButton imageButton_add,imageButton_jian;
    TextView textView_num;
    LiveDataActivityViewModel liveDataActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        imageButton_add = findViewById(R.id.imageButton_add);
        imageButton_jian = findViewById(R.id.imageButton_jian);
        textView_num = findViewById(R.id.textView_num);
        //获取viewmodel
        liveDataActivityViewModel = ViewModelProviders.of(this).get(LiveDataActivityViewModel.class);
        //关键点，创建数字的观察者，观察数字的变化，然后通知到主界面
        liveDataActivityViewModel.getNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView_num.setText(String.valueOf(integer));
            }
        });
        //改变viewmodel num中的数据的数值
        imageButton_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveDataActivityViewModel.getNum().setValue(liveDataActivityViewModel.getNum().getValue()+1);
            }
        });
        //改变viewmodel num中的数据的数值
        imageButton_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveDataActivityViewModel.getNum().setValue(liveDataActivityViewModel.getNum().getValue()-1);
            }
        });


    }
}
