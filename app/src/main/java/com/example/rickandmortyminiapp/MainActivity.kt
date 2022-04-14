package com.example.rickandmortyminiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFragment()

    }

    private fun setupFragment() {
        navController = (supportFragmentManager.findFragmentById(R.id.frav_view)
                as NavHostFragment).navController
        setupActionBarWithNavController(navController)
    }

}