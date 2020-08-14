package com.gmail.maks347743.core_impl.network

import com.gmail.maks347743.core_api.network.ApiProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent : ApiProvider