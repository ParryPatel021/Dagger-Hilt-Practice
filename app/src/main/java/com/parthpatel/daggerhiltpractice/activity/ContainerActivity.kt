package com.parthpatel.daggerhiltpractice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parthpatel.daggerhiltpractice.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
    }
}