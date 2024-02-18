package com.hyper.medicineapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hyper.medicineapp.feature_home.presentation.view.screen.MedicineDetailsScreen
import com.hyper.medicineapp.feature_home.presentation.view.screen.MedicineListScreen
import com.hyper.medicineapp.feature_home.presentation.viewmodel.MedicationItemViewModel
import com.hyper.medicineapp.feature_login.presentation.view.LoginScreen
import com.hyper.medicineapp.feature_login.presentation.viewmodel.LoginViewModel


@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "login"
) {

    val loginViewModel: LoginViewModel = hiltViewModel()
    val medicationItemViewModel: MedicationItemViewModel = hiltViewModel()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("login") {
            LoginScreen(
                onNavigateToHome = { navController.navigate("home") },
                loginViewModel = loginViewModel
            )
        }

        composable("home") {
            MedicineListScreen(
                onNavigateToDetails = { navController.navigate("details") },
                onNavigateBackToLogin = { navController.popBackStack() },
                loginViewModel = loginViewModel,
                MedicationItemViewModel = medicationItemViewModel
            )
        }

        composable("details") {
            MedicineDetailsScreen(
                onNavigateBackToHome = { navController.popBackStack() },
                medicationItemViewModel = medicationItemViewModel
            )
        }
    }
}