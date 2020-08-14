package com.gmail.maks347743.core_ui_utils

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<T : BaseViewModel>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract var viewModel: T

    override fun onResume() {
        super.onResume()
        viewModel.bindNavigator(findNavController())
    }

    override fun onPause() {
        super.onPause()
        viewModel.unbindNavigator()
    }

}