package com.gmail.maks347743.core

import com.gmail.maks347743.core_api.ContextProvider
import com.gmail.maks347743.core_api.network.ApiProvider
import com.gmail.maks347743.core_api.resources.ResourceProvider
import com.gmail.maks347743.core_impl.network.DaggerNetworkComponent
import com.gmail.maks347743.core_impl.resources.DaggerResourceProviderComponent

object CoreProvidersFactory {

    fun createResourceProvider(contextProvider: ContextProvider): ResourceProvider {
        return DaggerResourceProviderComponent.builder().contextProvider(contextProvider).build()
    }

    fun createApiProvider(): ApiProvider = DaggerNetworkComponent.create()

}