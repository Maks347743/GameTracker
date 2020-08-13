package com.gmail.maks347743.gametracker

import android.app.Application
import com.gmail.maks347743.core_api.ProviderHolder
import com.gmail.maks347743.core_api.ProvidersAggregator
import com.gmail.maks347743.gametracker.di.ProvidersComponent

class App : Application(), ProviderHolder {

    override fun getProvidersAggregator(): ProvidersAggregator {
        return providersComponent ?: ProvidersComponent.init(this).also {
            providersComponent = it
        }
    }

    companion object {
        private var providersComponent: ProvidersComponent? = null
    }

}