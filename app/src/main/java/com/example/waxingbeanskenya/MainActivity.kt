 package com.example.waxingbeanskenya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.waxingbeanskenya.data.Product
import com.example.waxingbeanskenya.data.products
import com.example.waxingbeanskenya.ui.theme.WaxingBeansKenyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaxingBeansKenyaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    WaxingBeansApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaxingBeansApp() {
    Scaffold(
        topBar = {
            WaxingTopBar()
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
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaxingTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier
    )
}

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .size(width = 150.dp, height = 200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    ProductImage(
                        productImage = product.imageResourceId
                    )
                    ProductInfo(
                        productName = product.name,
                        productPrice = product.price
                    )
                }
            }
        }
    }
}

@Composable
fun ProductImage(
    @DrawableRes productImage: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(MaterialTheme.shapes.medium),,
        contentScale = ContentScale.FillWidth,
        painter = painterResource(productImage),
        contentDescription = null)
}

@Composable
fun ProductInfo(
    @StringRes productName: Int,
    @StringRes productPrice: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
    ) {
        Text(
            text = stringResource(productName),
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = stringResource(productPrice),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview
@Composable
fun WaxingShopPreview() {
    WaxingBeansKenyaTheme(darkTheme = false) {
        WaxingBeansApp()
    }
}

@Preview
@Composable
fun WaxingDarkThemePreview() {
    WaxingBeansKenyaTheme(darkTheme = true) {
        WaxingBeansApp()
    }
}