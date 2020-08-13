package com.gmail.maks347743.core

import com.gmail.maks347743.core_api.ContextProvider
import com.gmail.maks347743.core_api.ResourceProvider
import com.gmail.maks347743.core_impl.resources.DaggerResourceProviderComponent

object CoreProvidersFactory {

    fun createResourceProvider(contextProvider: ContextProvider): ResourceProvider {
        return DaggerResourceProviderComponent.builder().contextProvider(contextProvider).build()
    }

}