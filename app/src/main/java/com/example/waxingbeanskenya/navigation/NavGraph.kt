package com.example.waxingbeanskenya.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.waxingbeanskenya.WaxingBeansApp
import com.example.waxingbeanskenya.ui.AccountScreen
import com.example.waxingbeanskenya.ui.CategoriesScreen
import com.example.waxingbeanskenya.ui.CheckoutScreen
import com.example.waxingbeanskenya.ui.ProductDetailPage
import com.example.waxingbeanskenya.ui.SettingsScreen
import com.example.waxingbeanskenya.ui.ShoppingCartScreen

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

        composable(
            route = Screen.ShoppingCart.route
        ){
            ShoppingCartScreen(navController = navController)
        }

        composable(
            route = Screen.CheckoutScreen.route
        ){
            CheckoutScreen(navController = navController)
        }

        composable(
            route = Screen.AccountScreen.route
        ){
            AccountScreen(navController = navController)

        }

        composable(
            route = Screen.SettingsScreen.route
        ){
            SettingsScreen(navController = navController)
        }
        
        composable(
            route = Screen.CategoriesScreen.route
        ){
            CategoriesScreen(navController = navController)
        }
    }
}