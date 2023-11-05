package com.example.waxingbeanskenya.navigation

sealed class Screen(val route: String){
    object WaxingShop: Screen(route = "waxing_shop_screen")
    object ProductDetail: Screen(route = "product_detail_screen")
    object ShoppingCart: Screen(route = "shopping_cart_screen")
    object CheckoutScreen: Screen(route = "checkout_screen")
}
