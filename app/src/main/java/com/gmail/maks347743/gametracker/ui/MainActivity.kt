package com.gmail.maks347743.gametracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.maks347743.gametracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}