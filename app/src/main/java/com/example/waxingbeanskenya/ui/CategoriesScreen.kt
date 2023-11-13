@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.waxingbeanskenya.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waxingbeanskenya.R
import com.example.waxingbeanskenya.ui.theme.WaxingBeansKenyaTheme

@Composable
fun CategoriesScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            CategoriesTopBar()
        },
        bottomBar = {
                    WaxingNavigationBar(navController = navController)
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
                    CategoriesTitle()
                    CategoriesCard()
                }
            }
        }
    )
}

@Composable
fun CategoriesTopBar() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }

        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun CategoriesTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.displayLarge
        )
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Outlined.List,
                contentDescription = null,
                Modifier.size(width = 25.dp, height = 25.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesCard() {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column {
            Card(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(250.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rose100),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )


            }

            Text(
                text = "Wax Beans",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )
        }

        Column {
            Card(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(250.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.waxwarmer),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )


            }

            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Wax Warmers",
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    WaxingBeansKenyaTheme {
        CategoriesScreen(navController = rememberNavController())
    }
}