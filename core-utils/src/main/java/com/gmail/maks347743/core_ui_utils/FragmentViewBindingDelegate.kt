package com.gmail.maks347743.core_ui_utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingDelegate<T : ViewBinding>(
    private val fragment: Fragment,
    private val bindingFunc: (View) -> T
) : ReadOnlyProperty<Fragment, T> {

    private var binding: T? = null

    init {
        fragment.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_CREATE) {
                    fragment.viewLifecycleOwnerLiveData.observe(fragment, Observer {
                        it.lifecycle.addObserver(object : LifecycleEventObserver {
                            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                                if (event == Lifecycle.Event.ON_DESTROY) {
                                    binding == null
                                }
                            }
                        })
                    })
                }
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) return binding
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not initialize binding when fragment view is destroyed")
        }
        return bindingFunc.invoke(thisRef.requireView()).also {
            this.binding = it
        }
    }

}