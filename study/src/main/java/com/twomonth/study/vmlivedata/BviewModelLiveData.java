package com.twomonth.study.vmlivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BviewModelLiveData extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number == null){
            number = new MutableLiveData<>(0);
        }
        return number;
    }

    public void add(int num){
        number.setValue(number.getValue()+num);
    }

    public void jian(int num){
        number.setValue(number.getValue()-num);
    }
}
