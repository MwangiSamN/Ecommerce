 package com.example.waxingbeanskenya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
        WaxingNavigationBar()
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
            .size(width = 150.dp, height = 250.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column {

                ProductImage(
                    productImage = product.imageResourceId
                )
                ProductInfo(
                    productName = product.name,
                    productPrice = product.price
                )
            }
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                FavouriteIcon()
            }
        }

    }
}

@Composable
fun ProductImage(
    @DrawableRes productImage: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Box {
            Image(
                modifier = Modifier
                    .size(width = 180.dp, height = 180.dp)
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(productImage),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ProductInfo(
    @StringRes productName: Int,
    @StringRes productPrice: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
    ) {
        Text(
            text = stringResource(productName),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(productPrice),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


    }
}

@Composable
fun FavouriteIcon() {

    IconButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(
            imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = null
        )
    }
}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@Composable
fun WaxingNavigationBar(){
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    

    val items = listOf(
        BottomNavigationItem(
            title = "Shop",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart
        ),
        BottomNavigationItem(
            title = "Category",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List
        ),
        BottomNavigationItem(
            title = "My Account",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle
        )
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { selectedItemIndex = index },
                label = { Text(item.title) },
                icon = {
                    Icon(
                        imageVector =
                        if (index == selectedItemIndex){
                                                  item.selectedIcon
                                                  } else{
                                                        item.unselectedIcon
                                                        },
                        contentDescription = item.title)
                }
            )
        }
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