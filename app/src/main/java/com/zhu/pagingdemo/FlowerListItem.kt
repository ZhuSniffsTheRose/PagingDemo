package com.zhu.pagingdemo

import com.zhu.pagingdemo.db.Flower

sealed class FlowerListItem(val name: String) {
    data class Item(val flower: Flower) : FlowerListItem(flower.name)
    data class Separator(private val letter: Char) : FlowerListItem(letter.uppercaseChar().toString())
}