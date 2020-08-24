package com.gmail.maks347743.feature_gamelist_impl.di

import com.gmail.maks347743.core_api.navigation.GameListFeatureNavigator
import com.gmail.maks347743.core_api.ProviderHolder
import com.gmail.maks347743.core_api.ProvidersAggregator
import com.gmail.maks347743.core_api.network.GamesApi
import com.gmail.maks347743.core_api.resources.Resources
import com.gmail.maks347743.core_api.viewmodel.ViewModelFactoryProvider
import com.gmail.maks347743.core_ui_utils.FeatureScope
import com.gmail.maks347743.feature_gamelist_impl.ui.GameListFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [GameListFeatureNavigator::class, Resources::class, GamesApi::class],
    modules = [GameListModule::class]
)
interface GameListFeatureComponent : ViewModelFactoryProvider {

    fun inject(gameListFragment: GameListFragment)

    companion object {

        private fun create(provider: ProvidersAggregator): GameListFeatureComponent {
            return DaggerGameListFeatureComponent
                .builder()
                .gameListFeatureNavigator(provider.gameListFeatureNavigator())
                .resources(provider.resourceProvider())
                .gamesApi(provider.api())
                .build()
        }

        fun injectFragment(fragment: GameListFragment): GameListFeatureComponent {
            val component =
                create((fragment.activity?.application as ProviderHolder).getProvidersAggregator())
            component.inject(fragment)
            return component
        }
    }

}