package com.gmail.maks347743.feature_gamelist_impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.maks347743.core_api.viewmodel.ViewModelKey
import com.gmail.maks347743.feature_gamelist_impl.ui.viewmodel.GameListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(GameListViewModel::class)
    fun gameListViewModel(viewModel: GameListViewModel): ViewModel

    @Binds
    fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}