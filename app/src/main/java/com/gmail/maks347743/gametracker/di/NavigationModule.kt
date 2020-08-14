package com.gmail.maks347743.gametracker.di

import com.gmail.maks347743.core_api.navigation.GameListFeatureNavigator
import com.gmail.maks347743.gametracker.navigation.GameListFeatureNavigatorImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun gameListFeatureNavigator(navigator: GameListFeatureNavigatorImpl): GameListFeatureNavigator

}