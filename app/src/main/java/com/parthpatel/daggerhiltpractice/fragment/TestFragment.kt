package com.parthpatel.daggerhiltpractice.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class TestFragment : Fragment() {

    @Inject
    @Named("StringFrg")
    lateinit var testStringFrg: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TestFragment", "Fragment String : $testStringFrg")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*Log.e("TestFragment", "Fragment String : $testStringFrg")*/
    }

}