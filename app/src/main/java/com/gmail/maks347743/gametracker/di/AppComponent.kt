package com.gmail.maks347743.gametracker.di

import android.content.Context
import com.gmail.maks347743.core_ui_utils.ResourceProvider
import com.gmail.maks347743.core_ui_utils.ResourceProviderImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun resourceProvider(): ResourceProvider

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

}

@Module
interface AppModule {
    @Binds
    @Singleton
    fun resourceProvider(resourceProvider: ResourceProviderImpl): ResourceProvider
}