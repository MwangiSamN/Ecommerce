package com.example.waxingbeanskenya

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.waxingbeanskenya.data.products
import com.example.waxingbeanskenya.navigation.SetupNavGraph
import com.example.waxingbeanskenya.ui.ProductItem
import com.example.waxingbeanskenya.ui.WaxingNavigationBar
import com.example.waxingbeanskenya.ui.WaxingTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaxingBeansApp(
    navController: NavController
) {

    Scaffold(
        topBar = {
            WaxingTopBar()
        },
        bottomBar = {
            WaxingNavigationBar(navController = navController)
        }
    ) {
            it ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = it
        ) {
            items(products){
                ProductItem(
                    navController = navController,
                    product = it,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_small))

                )
            }
        }

    }

}

