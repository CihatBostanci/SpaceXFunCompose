package com.example.spacexfuncompose.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * @author by cihat.bostanci
 * [BaseViewModel] abstracts all ViewModel
 */
abstract class BaseViewModel : ViewModel() {

    private val loading = MutableLiveData(false)
    val loadingLiveData: LiveData<Boolean>
        get() = loading

    /**
     * This dsl is written for all remote,local operations that manages loading bar.
     */
    fun <T> launchDataLoad(block: suspend () -> T?): T? {
        loading.value = true

        var res: T? = null
        viewModelScope.launch {
            try {
                res = block()
            } catch (error: Throwable) {
                Log.e(javaClass.canonicalName, error.message, error)
            } finally {
                loading.value = false
            }
        }

        return res
    }
}