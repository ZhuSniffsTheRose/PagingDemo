package com.zhu.pagingdemo.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Zhu
 * @date 2021/5/18 11:45 AM
 * @desc
 */
@Entity
data class Flower(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)
