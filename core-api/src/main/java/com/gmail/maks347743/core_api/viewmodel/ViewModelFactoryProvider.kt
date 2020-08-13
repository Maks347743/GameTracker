package com.gmail.maks347743.core_api.viewmodel

import androidx.lifecycle.ViewModelProvider

interface ViewModelFactoryProvider {
    fun viewModelFactory(): ViewModelProvider.Factory
}