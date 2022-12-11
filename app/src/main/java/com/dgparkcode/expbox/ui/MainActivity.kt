/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dgparkcode.expbox.R
import com.dgparkcode.expbox.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navCallback = NavController.OnDestinationChangedListener { _, destination, _ ->
            binding.mainBottomNav.isVisible = MAIN_FRAGMENT_IDS.contains(destination.id)
        }
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(navCallback)

        binding.mainBottomNav.setupWithNavController(navController)
    }

    companion object {
        private val MAIN_FRAGMENT_IDS = listOf(R.id.productsFragment)
    }
}