package com.example.waxingbeanskenya.navigation

sealed class Screen (val route: String){
    object WaxingShopScreen: Screen("home_screen")
    object ProductDetailsScreen: Screen("product_details_screen")
}