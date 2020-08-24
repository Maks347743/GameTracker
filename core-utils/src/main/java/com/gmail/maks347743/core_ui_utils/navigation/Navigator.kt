package com.gmail.maks347743.core_ui_utils.navigation

import androidx.navigation.NavController

interface Navigator {

    var navController: NavController?

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        this.navController = null
    }
}