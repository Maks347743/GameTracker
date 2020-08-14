package com.gmail.maks347743.core_impl.resources

import com.gmail.maks347743.core_api.resources.Resources
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ResourceModule {

    @Binds
    @Singleton
    fun resourceProvider(resourceProvider: ResourcesImpl): Resources

}
