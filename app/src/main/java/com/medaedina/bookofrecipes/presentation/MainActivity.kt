package com.medaedina.bookofrecipes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.medaedina.bookofrecipes.R
import com.medaedina.bookofrecipes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController
        val navigationGraph =
            navHostFragment.navController.navInflater.inflate(R.navigation.nav_graph)
        navController.graph = navigationGraph

        setupWithNavController(binding.bottomNavigationView, navController)

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.generateRecipeFragment -> {
                    navController.navigate(R.id.generateRecipeFragment)
                    true
                }

                R.id.recipeListFragment -> {
                    navController.navigate(R.id.recipeListFragment)
                    true
                }

                else -> false
            }
        }

        binding.bottomNavigationView.selectedItemId = R.id.generateRecipeFragment
    }
}