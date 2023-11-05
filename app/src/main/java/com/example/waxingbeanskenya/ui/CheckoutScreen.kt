package com.example.waxingbeanskenya.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waxingbeanskenya.R
import com.example.waxingbeanskenya.navigation.Screen
import com.example.waxingbeanskenya.ui.theme.WaxingBeansKenyaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            CheckoutTopBar(navController = navController)
        },
        content = {it
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CheckoutScreenTitle()
                CheckoutOutlinedButtons(navController = navController)
            }
        }
    )
}

@Composable
fun CheckoutTopBar(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
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
                    navController.navigate(Screen.ShoppingCart.route){
                        popUpTo(Screen.ProductDetail.route){
                            inclusive = true
                        }
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null)
            }
        }

        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null)
            }
        }
    }
}

@Composable
fun CheckoutScreenTitle() {
    Row(
        modifier = Modifier.padding(20.dp)
    ) {
        Text(
            text = stringResource(R.string.checkout_screen),
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Composable
fun CheckoutOutlinedButtons(
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors()
        ) {
            Text(
                text = stringResource(R.string.place_order)
            )
        }

        OutlinedButton(
            onClick = {
                      navController.navigate(Screen.ShoppingCart.route)
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = stringResource(R.string.update_order),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    WaxingBeansKenyaTheme {
        CheckoutScreen(navController = rememberNavController())
    }
}