package com.zhu.pagingdemo.utils

import java.util.concurrent.Executors

fun runLongTask(longTask: () -> Unit) {
    Executors.newSingleThreadExecutor().execute(longTask)
}