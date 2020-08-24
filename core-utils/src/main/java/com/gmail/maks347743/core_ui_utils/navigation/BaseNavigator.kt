package com.gmail.maks347743.core_ui_utils.navigation

import androidx.navigation.NavController
import com.gmail.maks347743.core_ui_utils.navigation.Navigator

abstract class BaseNavigator :
    Navigator {

    override var navController: NavController? = null

}