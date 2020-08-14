package com.gmail.maks347743.core_ui_utils

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

abstract class BaseViewModel(private val navigator: Navigator) : ViewModel() {

    fun bindNavigator(navController: NavController) {
        navigator.bind(navController)
    }

    fun unbindNavigator() {
        navigator.unbind()
    }

}