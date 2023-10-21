package com.example.waxingbeanskenya.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.waxingbeanskenya.R

data class Product(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val price: Int
)

val products = listOf(
    Product(
        R.drawable.waxbeans,
        R.string.product_name_1,
        R.string.product_price_1
    ),
    Product(
        R.drawable.waxbeans,
        R.string.product_name_2,
        R.string.product_price_2
    ),
    Product(
        R.drawable.waxbeans,
        R.string.product_name_3,
        R.string.product_price_3
    )
)