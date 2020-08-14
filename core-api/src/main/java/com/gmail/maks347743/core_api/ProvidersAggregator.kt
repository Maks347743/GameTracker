package com.gmail.maks347743.core_api

import com.gmail.maks347743.core_api.navigation.NavigatorProvider
import com.gmail.maks347743.core_api.network.ApiProvider
import com.gmail.maks347743.core_api.resources.ResourceProvider

interface ProvidersAggregator : ContextProvider,
    NavigatorProvider, ResourceProvider, ApiProvider