package com.example.waxingbeanskenya.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.waxingbeanskenya.WaxingBeansApp
import com.example.waxingbeanskenya.ui.ProductDetailPage

@Composable
fun SetupNavGraph(
    navController: NavController
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.WaxingShop.route
    ){
        composable(
            route = Screen.WaxingShop.route
        ){
            WaxingBeansApp(navController = navController)
        }
        composable(
            route = Screen.ProductDetail.route
        ){
            ProductDetailPage(navController = navController)
        }
    }
}