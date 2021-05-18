package com.zhu.pagingdemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.zhu.pagingdemo.model.FlowerViewModel
import com.zhu.pagingdemo.model.FlowerViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<FlowerViewModel> { FlowerViewModelFactory(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}