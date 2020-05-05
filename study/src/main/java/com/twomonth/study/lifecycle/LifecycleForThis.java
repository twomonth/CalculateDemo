package com.twomonth.study.lifecycle;

import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

class LifecycleForThis implements LifecycleObserver {

    private static String TAG;

    LifecycleForThis(String tag) {
        TAG = tag;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(){
        Log.e(TAG,"======>ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart(){
        Log.e(TAG,"======>ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(){
        Log.e(TAG,"======>ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(){
        Log.e(TAG,"======>ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(){
        Log.e(TAG,"======>ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(){
        Log.e(TAG,"======>ON_DESTROY");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(){
        Log.e(TAG,"======>ON_ANY");
    }


}
