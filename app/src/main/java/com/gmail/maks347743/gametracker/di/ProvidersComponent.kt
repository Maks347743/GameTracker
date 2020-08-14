package com.gmail.maks347743.gametracker.di

import android.content.Context
import com.gmail.maks347743.core.CoreProvidersFactory
import com.gmail.maks347743.core_api.ContextProvider
import com.gmail.maks347743.core_api.ProvidersAggregator
import com.gmail.maks347743.core_api.network.ApiProvider
import com.gmail.maks347743.core_api.resources.ResourceProvider
import dagger.Component

@Component(
    dependencies = [ContextProvider::class, ResourceProvider::class, ApiProvider::class],
    modules = [NavigationModule::class]
)
interface ProvidersComponent : ProvidersAggregator {

    companion object {

        fun init(context: Context): ProvidersComponent =
            DaggerProvidersComponent.builder()
                .contextProvider(AppComponent.create(context))
                .resourceProvider(
                    CoreProvidersFactory.createResourceProvider(AppComponent.create(context)))
                .apiProvider(CoreProvidersFactory.createApiProvider())
                .build()

    }

}