package com.gmail.maks347743.core_ui_utils

import androidx.navigation.NavController

abstract class BaseNavigator {

    protected var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }
}