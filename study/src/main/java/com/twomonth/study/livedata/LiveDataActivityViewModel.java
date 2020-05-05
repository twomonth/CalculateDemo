package com.twomonth.study.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataActivityViewModel extends ViewModel {

    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum() {
        if (num == null){
            num = new MutableLiveData<>(0);
        }
        return num;
    }

    public void setNum(MutableLiveData<Integer> num) {
        this.num = num;
    }
}
