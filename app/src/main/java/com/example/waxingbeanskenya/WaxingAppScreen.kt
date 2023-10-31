package com.example.waxingbeanskenya

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.waxingbeanskenya.data.products
import com.example.waxingbeanskenya.ui.ProductItem
import com.example.waxingbeanskenya.ui.WaxingNavigationBar
import com.example.waxingbeanskenya.ui.WaxingTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaxingBeansApp() {

    Scaffold(
        topBar = {
            WaxingTopBar()
        },
        bottomBar = {
            WaxingNavigationBar()
        }
    ) {
            it ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = it
        ) {
            items(products){
                ProductItem(
                    product = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }




    }
}

