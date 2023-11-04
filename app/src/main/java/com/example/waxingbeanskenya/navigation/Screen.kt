package com.example.waxingbeanskenya.navigation

sealed class Screen(val route: String){
    object WaxingShop: Screen(route = "waxing_shop_screen")
    object ProductDetail: Screen(route = "product_detail_screen")
}
