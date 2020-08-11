package com.gmail.maks347743.gametracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.maks347743.feature_gamelist_impl.ui.GameListFragment
import com.gmail.maks347743.gametracker.R
import com.gmail.maks347743.gametracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, GameListFragment())
                .commitAllowingStateLoss()
        }
    }
}