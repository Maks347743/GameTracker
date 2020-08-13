package com.gmail.maks347743.gametracker.di

import android.content.Context
import com.gmail.maks347743.core_api.ContextProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent : ContextProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    companion object {

        private var contextProvider: ContextProvider? = null

        fun create(context: Context): ContextProvider {
            return contextProvider ?: DaggerAppComponent
                .builder()
                .context(context)
                .build().also {
                    contextProvider = it
                }
        }

    }

}