package com.parthpatel.daggerhiltpractice.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class TestViewModel @Inject constructor(@Named("StringTwo") testStringTwo: String) : ViewModel() {

    init {
        Log.e("ViewModel", "Injected String is:  $testStringTwo")
    }

}