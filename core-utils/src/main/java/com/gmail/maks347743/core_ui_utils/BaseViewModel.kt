package com.gmail.maks347743.core_ui_utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel(private val navigator: Navigator) : ViewModel() {

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> = _error
    val errorHandler = CoroutineExceptionHandler { _, error ->
        this._error.postValue(error.message)
    }

    fun bindNavigator(navController: NavController) {
        navigator.bind(navController)
    }

    fun unbindNavigator() {
        navigator.unbind()
    }

}