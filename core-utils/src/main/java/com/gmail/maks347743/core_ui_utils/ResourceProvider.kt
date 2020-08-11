package com.gmail.maks347743.core_ui_utils

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

interface ResourceProvider {
    fun string(@StringRes id: Int): String
}

class ResourceProviderImpl @Inject constructor(private val context: Context) : ResourceProvider {

    override fun string(id: Int): String = context.resources.getString(id)

}