package com.zhu.pagingdemo.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.zhu.pagingdemo.FlowerListItem
import com.zhu.pagingdemo.db.Flower
import com.zhu.pagingdemo.db.FlowerDB
import com.zhu.pagingdemo.db.FlowerDao
import com.zhu.pagingdemo.utils.runLongTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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
            @Suppress("UNCHECKED_CAST")
            return FlowerViewModel(flowerDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class FlowerViewModel(private val dao: FlowerDao) : ViewModel() {
    val allFlowers: Flow<PagingData<Flower>> = Pager(PagingConfig(10), pagingSourceFactory = { dao.allFlowersByName() }
    ).flow.cachedIn(viewModelScope)

    fun insert(text: CharSequence) = runLongTask {
        dao.insert(Flower(id = 0, name = text.toString()))
    }
}