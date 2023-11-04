package com.example.waxingbeanskenya.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waxingbeanskenya.R
import com.example.waxingbeanskenya.WaxingBeansApp
import com.example.waxingbeanskenya.data.Product
import com.example.waxingbeanskenya.navigation.Screen
import com.example.waxingbeanskenya.ui.theme.WaxingBeansKenyaTheme

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
    navController: NavController,
    modifier: Modifier = Modifier,
    product: Product
){
    Card(
        modifier = modifier
            .size(width = 150.dp, height = 250.dp)
            .clickable {
                       navController.navigate(route = Screen.ProductDetail.route)
            },
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
    @StringRes productPrice: Int
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
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }


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
        WaxingBeansApp(navController = rememberNavController())
    }
}

@Preview
@Composable
fun WaxingDarkThemePreview() {
    WaxingBeansKenyaTheme(darkTheme = true) {
        WaxingBeansApp(navController = rememberNavController())
    }
}