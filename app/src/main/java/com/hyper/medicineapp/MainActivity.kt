package com.hyper.medicineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hyper.medicineapp.navigation.MyAppNavHost
import com.hyper.medicineapp.ui.theme.MedicineAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MedicineAppTheme {
                MyAppNavHost()
            }
        }
    }
}