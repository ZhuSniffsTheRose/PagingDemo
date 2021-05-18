package com.zhu.pagingdemo.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zhu.pagingdemo.db.FlowerDB
import com.zhu.pagingdemo.db.FlowerDao

/**
 * @author Zhu
 * @date 2021/5/18 12:09 PM
 * @desc
 */
class FlowerViewModelFactory(
        private val app: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FlowerViewModel::class.java)) {
            val flowerDao = FlowerDB.get(app).flowerDao()
            @Suppress("UNCHECKED_CAST") // Guaranteed to succeed at this point.
            return FlowerViewModel(flowerDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class FlowerViewModel(private val dao: FlowerDao) : ViewModel() {



}