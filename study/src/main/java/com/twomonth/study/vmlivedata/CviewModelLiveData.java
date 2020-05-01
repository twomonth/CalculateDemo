package com.twomonth.study.vmlivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class CviewModelLiveData extends ViewModel {
//    private MutableLiveData<Integer> number;
    private static final String NUM = "num";
    private SavedStateHandle handle;
    public CviewModelLiveData(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if (!handle.contains(NUM)){
            handle.set(NUM,0);
        }
        return handle.getLiveData(NUM);
    }

    public void add(int num){
        getNumber().setValue(getNumber().getValue()+1);
    }

    public void jian(int num){
        getNumber().setValue(getNumber().getValue()-1);
    }
}
