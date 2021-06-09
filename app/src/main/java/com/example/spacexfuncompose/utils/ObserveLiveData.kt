package com.example.spacexfuncompose.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LifecycleOwner?.observeLiveData(
    liveData: LiveData<T>,
    crossinline observe: (T) -> Unit
) = this?.run {
    Observer<T> {
        observe(it)
    }.also {
        liveData.observe(this, it)
    }
}