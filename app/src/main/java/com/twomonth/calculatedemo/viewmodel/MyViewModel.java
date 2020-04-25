package com.twomonth.calculatedemo.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import java.util.Random;

/**
 * 作者:       wjc
 * 创建时间:    2020/4/24 22:28
 * 描述:
 * 修改时间:    2020/4/24 22:28
 */
public class MyViewModel extends AndroidViewModel {
    private static String KEY_HIGH_SCORE = "key_high_score";
    private static String KEY_LEFT_NUMBER = "key_left_number";
    private static String KEY_RIGHT_NUMBER = "key_right_number";
    private static String KEY_OPERATOR = "key_operator";
    private static String KEY_ANSWER = "key_answer";
    private static String KEY_CURRENT_SCORE = "key_current_score";
    private static String SAVE_SHP_DATA_NAME = "save_shp_data_name";
    public boolean win_flag = false;
    private SavedStateHandle handle;
    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        if (!handle.contains(KEY_HIGH_SCORE)){
            SharedPreferences sharedPreferences = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME, Context.MODE_PRIVATE);
            handle.set(KEY_HIGH_SCORE,sharedPreferences.getInt(KEY_HIGH_SCORE,0));
            handle.set(KEY_LEFT_NUMBER,0);
            handle.set(KEY_RIGHT_NUMBER,0);
            handle.set(KEY_OPERATOR,"+");
            handle.set(KEY_ANSWER,0);
            handle.set(KEY_CURRENT_SCORE,1);
        }
        this.handle = handle;
    }

    public MutableLiveData<Integer> getLeftNumber(){
        return handle.getLiveData(KEY_LEFT_NUMBER);
    }

    public MutableLiveData<Integer> getRightNumber(){
        return handle.getLiveData(KEY_RIGHT_NUMBER);
    }

    public MutableLiveData<String> getOperator(){
        return handle.getLiveData(KEY_OPERATOR);
    }

    public MutableLiveData<Integer> getHightScore(){
        return handle.getLiveData(KEY_HIGH_SCORE);
    }

    public MutableLiveData<Integer> getCurrentScore(){
        return handle.getLiveData(KEY_CURRENT_SCORE);
    }

    public MutableLiveData<Integer> getAnswer(){
        return handle.getLiveData(KEY_ANSWER);
    }

    public void generator (){
        int LEVEL = 50;
        int x,y;
        Random random = new Random();
        x = random.nextInt(LEVEL)+1;
        y = random.nextInt(LEVEL)+1;

        getLeftNumber().setValue(x);
        getRightNumber().setValue(y);

        //+ - * /
        if (new Random().nextInt(3)==0){
            getOperator().setValue("+");
            getAnswer().setValue(x+y);
        }else if(new Random().nextInt(3)==1) {
            //不要出现负数
            if (x<y){
                int i = x;
                x = y;
                y = i;
                getLeftNumber().setValue(x);
                getRightNumber().setValue(y);
            }
            getOperator().setValue("-");
            getAnswer().setValue(x-y);
        }else if (new Random().nextInt(3)==2){
            getOperator().setValue("x");
            getAnswer().setValue(x*y);
        }else {
            getOperator().setValue("÷");
            //不要出现小数
            int i = x*y;
            y = x;
            x = i ;
            getLeftNumber().setValue(x);
            getRightNumber().setValue(y);
            getAnswer().setValue(x/y);
        }
    }

    public void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(SAVE_SHP_DATA_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(KEY_HIGH_SCORE,getHightScore().getValue());
        editor.apply();
    }

    public void answerCorrect(){
        getCurrentScore().setValue(getCurrentScore().getValue()+1);
        if (getCurrentScore().getValue()>getHightScore().getValue()){
            getHightScore().setValue(getCurrentScore().getValue()-1);
            save();
            win_flag = true;
        }
        generator();
    }
}
