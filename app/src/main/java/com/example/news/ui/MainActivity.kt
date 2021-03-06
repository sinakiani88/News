package com.example.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.news.R
import com.example.news.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            setSupportActionBar(toolbar)
            val navController = findNavController(R.id.fragmentContainer)
            NavigationUI.setupWithNavController(bottomNavigationView,navController)
            navController.addOnDestinationChangedListener{_,destination, _->
                when(destination.id){
                    R.id.articleFrag->bottomNavigationView.visibility = View.GONE
                    else->bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }
    }
}