package com.example.waxingbeanskenya.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.waxingbeanskenya.ui.ProductDetailPage

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WaxingShopScreen.route
    ){
        composable(
            Screen.WaxingShopScreen.route
        ){
            ProductDetailPage()
        }
    }
}