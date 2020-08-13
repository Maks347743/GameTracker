package com.gmail.maks347743.feature_gamelist_impl.di

import com.gmail.maks347743.core_api.GameListFeatureNavigator
import com.gmail.maks347743.core_api.ProvidersAggregator
import com.gmail.maks347743.core_api.Resources
import com.gmail.maks347743.core_api.viewmodel.ViewModelFactoryProvider
import com.gmail.maks347743.core_ui_utils.FeatureScope
import com.gmail.maks347743.feature_gamelist_impl.ui.GameListFragment
import dagger.Component

@FeatureScope
@Component(dependencies = [GameListFeatureNavigator::class, Resources::class],
modules = [ViewModelModule::class])
interface GameListFeatureComponent : ViewModelFactoryProvider {

    fun inject(gameListFragment: GameListFragment)

    companion object {
        fun create(provider: ProvidersAggregator): GameListFeatureComponent {
            return DaggerGameListFeatureComponent
                .builder()
                .gameListFeatureNavigator(provider.gameListFeatureNavigator())
                .resources(provider.resourceProvider())
                .build()
        }
    }

}