package uz.alisoft.office.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yatik.qrscanner.ui.MainActivity1
import dagger.hilt.android.AndroidEntryPoint
import uz.alisoft.office.AppColor
import uz.alisoft.office.R
import uz.alisoft.office.databinding.ActivityMainHBinding
import uz.alisoft.office.util.setStatusBarColor

@AndroidEntryPoint
class WiperActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainHBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarColor(AppColor.white, AppColor.black, false)
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        /* val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_projects,
                R.id.navigation_history,
                R.id.navigation_settings
            )
        )*/
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        binding.cardScan.setOnClickListener {
            Intent(this@WiperActivity, MainActivity1::class.java).apply {
                startActivity(this)
            }
        }
    }
}