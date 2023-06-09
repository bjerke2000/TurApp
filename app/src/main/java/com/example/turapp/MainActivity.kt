package com.example.turapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean { /*Nå vi trykk på knappen for å naviger tilbake blir denne funksjonen kalt*/
        return navController.navigateUp() || super.onSupportNavigateUp() /*Derfor fortell vi i denne funksjonen at navigasjons kontrollern skal naviger tilbake, om det ikke lar sæ gjør håntera default func det*/
    }
}