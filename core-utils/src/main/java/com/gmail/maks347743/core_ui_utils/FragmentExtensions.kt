package com.gmail.maks347743.core_ui_utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> Fragment.viewBinding(viewBindingFunc: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFunc)