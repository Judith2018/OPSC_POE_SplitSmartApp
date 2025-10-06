package com.example.splitsmart_poe.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.splitsmart_poe.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navController = findNavController(R.id.nav_host_fragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val fab = findViewById<FloatingActionButton>(R.id.fab_add)

        // Link bottom nav to navigation graph
        bottomNav.setupWithNavController(navController)

        // FAB triggers dialog logic in HomeFragment (if visible)
        fab.setOnClickListener {
            // We’ll handle the actual dialogs inside HomeFragment
            val currentFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment)
                ?.childFragmentManager
                ?.fragments
                ?.firstOrNull()

            if (currentFragment is HomeFragment) {
                currentFragment.showAddOptions()
            }
        }
    }
}
