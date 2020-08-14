package com.gmail.maks347743.core_impl.resources

import com.gmail.maks347743.core_api.ContextProvider
import com.gmail.maks347743.core_api.resources.ResourceProvider
import com.gmail.maks347743.core_impl.resources.ResourceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [ContextProvider::class], modules = [ResourceModule::class])
interface ResourceProviderComponent :
    ResourceProvider
