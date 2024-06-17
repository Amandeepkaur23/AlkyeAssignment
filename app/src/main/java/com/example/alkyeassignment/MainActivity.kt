package com.example.alkyeassignment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.alkyeassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //find navHostFragment by using findViewById
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //get the navController that is used to handle navigation
        val navController = navHostFragment.navController

        //set up bottom navigation bar using navController
        binding.bottomNav.setupWithNavController(navController)

        //control the visibility
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    binding.bottomNav.visibility = View.GONE
                    binding.linearLayout.setBackgroundColor(Color.WHITE)
                }
                else -> {
                    binding.bottomNav.visibility = View.VISIBLE
                    binding.linearLayout.setBackgroundColor(Color.BLACK)
                }
            }
        }
    }
}
