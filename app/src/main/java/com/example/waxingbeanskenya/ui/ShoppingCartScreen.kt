package com.example.waxingbeanskenya.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.waxingbeanskenya.navigation.Screen
import com.example.waxingbeanskenya.ui.theme.WaxingBeansKenyaTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            CartTopBar(navController = navController)
        },

        content = {it
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    ShoppingCartTitle()
                    CartItem(navController = navController)
                }
                Column {
                    ShoppingCartOutlineButtons(navController = navController)
                }

            }
        }
    )
}

@Composable
fun CartTopBar(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            IconButton(
                onClick = {
                          navController.navigate(Screen.ProductDetail.route){
                              popUpTo(Screen.ProductDetail.route){
                                  inclusive = true
                              }
                          }
                },

            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }

        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            IconButton(
                onClick = { navController.navigate(Screen.AccountScreen.route) }
            ) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun ShoppingCartTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.shopping_cart),
            style = MaterialTheme.typography.displayLarge
        )

        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = null,
                tint = androidx.compose.ui.graphics.Color.Red,
                modifier = Modifier.size(width = 25.dp, height = 25.dp),
            )
        }
    }
}

@Composable
fun CartItem(
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                navController.navigate(Screen.ProductDetail.route)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CartItemDetails()
            CartItemModification()

        }
    }
}

@Composable
fun CartItemDetails() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(90.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.rose100),
            contentDescription = null
        )

        Column {
            Text(
                text = stringResource(R.string.product_name_1),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
            )

            Text(
                text = stringResource(R.string.product_price_1),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Composable
fun CartItemModification() {
    Surface(
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .size(width = 90.dp, height = 35.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = null
                )
            }

            Text(
                text = "1",
                style = MaterialTheme.typography.labelSmall
            )

            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = null
                )
            }
        }

    }
}

@Composable
fun ShoppingCartOutlineButtons(
    navController: NavController
){
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Button(
            onClick = {
                      navController.navigate(Screen.CheckoutScreen.route)
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.proceed_to_checkout)
            )
        }

        OutlinedButton(
            onClick = {
                      navController.navigate(Screen.WaxingShop.route)
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.add_more_items),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartPreview() {
    WaxingBeansKenyaTheme {
        ShoppingCartScreen(navController = rememberNavController())
    }
}