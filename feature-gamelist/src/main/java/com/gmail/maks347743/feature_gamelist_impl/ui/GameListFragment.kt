package com.gmail.maks347743.feature_gamelist_impl.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gmail.maks347743.core_ui_utils.BaseFragment
import com.gmail.maks347743.core_ui_utils.viewBinding
import com.gmail.maks347743.feature_gamelist_impl.R
import com.gmail.maks347743.feature_gamelist_impl.databinding.FragmentGameListBinding
import com.gmail.maks347743.feature_gamelist_impl.di.GameListFeatureComponent
import com.gmail.maks347743.feature_gamelist_impl.ui.viewmodel.GameListViewModel

class GameListFragment : BaseFragment<GameListViewModel>(R.layout.fragment_game_list) {

    private val component by lazy {
        GameListFeatureComponent.injectFragment(this)
    }
    private val binding by viewBinding(FragmentGameListBinding::bind)
    override lateinit var viewModel: GameListViewModel
    private val adapter = GameListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, component.viewModelFactory()).get(GameListViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerGameList.adapter = adapter
        viewModel.data.observe(this.viewLifecycleOwner, Observer {
            adapter.items = it
        })
    }

}