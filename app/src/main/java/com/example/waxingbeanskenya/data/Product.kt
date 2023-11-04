package com.example.waxingbeanskenya.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.waxingbeanskenya.R

data class Product(
    val id: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val price: Int
)

val products = listOf(
    Product(
        1,
        R.drawable.rose100,
        R.string.product_name_1,
        R.string.product_price_1
    ),
    Product(
        2,
        R.drawable.rose100,
        R.string.product_name_2,
        R.string.product_price_2
    ),
    Product(
        2,
        R.drawable.rose100,
        R.string.product_name_3,
        R.string.product_price_3
    ),
    Product(
        4,
        R.drawable.rose100,
        R.string.product_name_1,
        R.string.product_price_1
    ),
    Product(
        5,
        R.drawable.rose100,
        R.string.product_name_2,
        R.string.product_price_2
    ),
    Product(
        6,
        R.drawable.rose100,
        R.string.product_name_3,
        R.string.product_price_3
    ),
    Product(
        7,
        R.drawable.rose100,
        R.string.product_name_1,
        R.string.product_price_1
    ),
    Product(
        8,
        R.drawable.rose100,
        R.string.product_name_2,
        R.string.product_price_2
    ),
    Product(
        9,
        R.drawable.rose100,
        R.string.product_name_3,
        R.string.product_price_3
    ),
    Product(
        10,
        R.drawable.rose100,
        R.string.product_name_3,
        R.string.product_price_3
    ),
    Product(
        11,
        R.drawable.rose100,
        R.string.product_name_1,
        R.string.product_price_1
    ),
    Product(
        12,
        R.drawable.rose100,
        R.string.product_name_2,
        R.string.product_price_2
    ),
    Product(
        13,
        R.drawable.rose100,
        R.string.product_name_3,
        R.string.product_price_3
    ),
    Product(
        14,
        R.drawable.rose100,
        R.string.product_name_1,
        R.string.product_price_1
    ),
    Product(
        15,
        R.drawable.rose100,
        R.string.product_name_2,
        R.string.product_price_2
    ),
    Product(
        16,
        R.drawable.rose100,
        R.string.product_name_3,
        R.string.product_price_3
    )
)