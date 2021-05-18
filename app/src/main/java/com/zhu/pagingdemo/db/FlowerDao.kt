package com.zhu.pagingdemo.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * @author Zhu
 * @date 2021/5/18 11:51 AM
 * @desc
 */
@Dao
interface FlowerDao {
    /**
     * Room knows how to return a LivePagedListProvider, from which we can get a LiveData and serve
     * it back to UI via ViewModel.
     */
    @Query("SELECT * FROM Flower ORDER BY name COLLATE NOCASE ASC")
    fun allCheesesByName(): PagingSource<Int, Flower>

    @Insert
    fun insert(cheeses: List<Flower>)

    @Insert
    fun insert(cheese: Flower)

    @Delete
    fun delete(cheese: Flower)
}