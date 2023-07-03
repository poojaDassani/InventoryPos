package com.whizzarc.inventorypos.splashscreen

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.whizzarc.inventorypos.R
import com.whizzarc.inventorypos.databinding.ActivitySplashScreenBinding
import com.whizzarc.inventorypos.services.data.dao.CustomerDao
import com.whizzarc.inventorypos.services.data.database.WhizzarcDatabase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySplashScreenBinding

    @Inject
    lateinit var customerDao : CustomerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            val customers = customerDao.getAllCustomers()
        }
        val navController = findNavController(R.id.nav_host_fragment_content_splash_screen)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_splash_screen)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}