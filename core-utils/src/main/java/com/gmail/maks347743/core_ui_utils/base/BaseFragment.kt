package com.gmail.maks347743.core_ui_utils.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

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

    fun showError() {
        Snackbar.make(requireView(), "Что-то пошло не так." +
                " Попробуйте перезапустить приложение", Snackbar.LENGTH_SHORT).show()
    }

}