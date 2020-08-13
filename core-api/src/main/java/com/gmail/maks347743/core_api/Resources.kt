package com.gmail.maks347743.core_api

import androidx.annotation.StringRes

interface Resources {
    fun string(@StringRes id: Int): String
}