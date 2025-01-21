package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleViewModel extends ViewModel {
    // MutableLiveData to hold a String value
    private MutableLiveData<String> foo;

    // Getter method to access MutableLiveData
    public MutableLiveData<String> getFoo() {
        if (foo == null) {
            foo = new MutableLiveData<>();
        }
        return foo;
    }
}
