package com.gmail.maks347743.feature_gamelist_impl.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.gmail.maks347743.core_ui_utils.viewBinding
import com.gmail.maks347743.feature_gamelist_impl.R
import com.gmail.maks347743.feature_gamelist_impl.databinding.FragmentGameListBinding
import com.gmail.maks347743.feature_gamelist_impl.ui.viewmodel.GameListViewModel

class GameListFragment : Fragment(R.layout.fragment_game_list) {

    private val binding by viewBinding(FragmentGameListBinding::bind)
    private val viewModel by viewModels<GameListViewModel>()
    private val adapter = GameListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerGameList.adapter = adapter
        viewModel.data.observe(this.viewLifecycleOwner, Observer {
            adapter.items = it
        })
    }

}