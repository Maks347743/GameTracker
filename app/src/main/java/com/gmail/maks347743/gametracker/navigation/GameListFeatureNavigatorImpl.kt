package com.gmail.maks347743.gametracker.navigation

import com.gmail.maks347743.core_api.GameListFeatureNavigator
import com.gmail.maks347743.core_ui_utils.BaseNavigator
import com.gmail.maks347743.gametracker.R
import javax.inject.Inject

class GameListFeatureNavigatorImpl @Inject constructor()
    : GameListFeatureNavigator, BaseNavigator() {

    override fun navigateToGameVideo() {
        navController?.navigate(R.id.action_gameListFragment_to_gameVideoFragment)
            ?: throw IllegalStateException("NavController must be bound to ${this.javaClass.name} before processing navigation")
    }

}