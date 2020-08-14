package com.gmail.maks347743.core_impl.resources

import android.content.Context
import com.gmail.maks347743.core_api.resources.Resources
import javax.inject.Inject

class ResourcesImpl @Inject constructor(private val context: Context) :
    Resources {

    override fun string(id: Int): String = context.resources.getString(id)

}
