package com.zhu.pagingdemo.utils

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

inline fun <reified BindingT : ViewBinding> AppCompatActivity.viewBindings(
        crossinline bind: (View) -> BindingT
) = object : Lazy<BindingT> {

    private var initialized: BindingT? = null

    override val value: BindingT
        get() = initialized ?: bind(
                findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
        ).also {
            initialized = it
        }

    override fun isInitialized() = initialized != null
}
