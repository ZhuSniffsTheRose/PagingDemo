package com.zhu.pagingdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zhu.pagingdemo.databinding.ActivityMainBinding
import com.zhu.pagingdemo.model.FlowerViewModel
import com.zhu.pagingdemo.model.FlowerViewModelFactory
import com.zhu.pagingdemo.utils.viewBindings
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel by viewModels<FlowerViewModel> { FlowerViewModelFactory(application) }

    private val binding by viewBindings(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flowerAdapter = FlowerAdapter()
        binding.flowerList.adapter = flowerAdapter

        lifecycleScope.launch {
            viewModel.allFlowers.collectLatest {  flowerAdapter.submitData(it)   }
        }

        binding.addButton.setOnClickListener {
            val newFlower = binding.inputText.text.trim()
            if (newFlower.isNotEmpty()) {
                viewModel.insert(newFlower)
                binding.inputText.setText("")
            }
        }
    }
}