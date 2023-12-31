@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.waxingbeanskenya.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
fun AccountScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            AccountScreenTopBar(navController = navController)
        },
        bottomBar = {
                    WaxingNavigationBar(navController = navController)
        },
        content = {it
            Box {
                Column(
                    modifier = Modifier
                        .padding(top = 80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProfileThumbNail()
                    FavOrdersCards()
                    AccountContent(navController = navController)
                }



            }
        }
    )
}

@Composable
fun AccountScreenTopBar(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Screen.SettingsScreen.route){
                        popUpTo(Screen.WaxingShop.route){
                            inclusive = false
                        }
                    }
                },
            ) {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = null
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileThumbNail() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(MaterialTheme.colorScheme.surfaceTint, CircleShape)

    ) {

        val sheetState = rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }

        if (isSheetOpen){
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { isSheetOpen = false },
                modifier = Modifier.height(200.dp),
                tonalElevation = 5.dp
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row {
                        Text(
                            text = "Edit Profile",
                            style = MaterialTheme.typography.labelLarge,

                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(top = 16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(imageVector = Icons.Outlined.Face, contentDescription = null)
                            Text(text = "Camera")
                        }

                        Column(
                            modifier = Modifier.padding(top = 16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(imageVector = Icons.Outlined.Edit, contentDescription = null)
                            Text(text = "Username")
                        }

                        Column(
                            modifier = Modifier.padding(top = 16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
                            Text(text = "Email")
                        }

                        Column(
                            modifier = Modifier.padding(top = 16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(imageVector = Icons.Outlined.Call, contentDescription = null)
                            Text(text = "Number")
                        }
                    }
                }

            }
        }

        Icon(
            imageVector = Icons.Outlined.AccountCircle,
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.Center)
        )

        Box(
            modifier = Modifier
                .size(60.dp)
                .background(MaterialTheme.colorScheme.surfaceTint, CircleShape)
                .align(Alignment.BottomEnd)
                .border(
                    width = 7.dp,
                    color = MaterialTheme.colorScheme.background,
                    shape = CircleShape
                )

        ) {
            IconButton(
                onClick = {
                          isSheetOpen = true
                },
                modifier = Modifier.align(Alignment.Center)


            ) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = null,

                )
            }
        }
    }

    Spacer(modifier = Modifier.height(10.dp))
    Column {
        Text(
            text = "Samkul",
            style = MaterialTheme.typography.displayMedium
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavOrdersCards() {
    Row(
        modifier = Modifier.padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(160.dp)
                .height(60.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Favourites",
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }

        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(160.dp)
                .height(60.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Orders",
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(10.dp))
    Divider(
        modifier = Modifier.padding(16.dp),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun AccountContent(
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.clickable {
                navController.navigate(Screen.SettingsScreen.route)
            }
        ) {
            Icon(imageVector = Icons.Outlined.Settings, contentDescription = null)

            Text(
                text = stringResource(R.string.settings),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.clickable {  }
        ) {
            Icon(imageVector = Icons.Outlined.MailOutline, contentDescription = null)

            Text(
                text = stringResource(R.string.feedback),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.clickable {  }
        ) {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = null)

            Text(
                text = stringResource(R.string.privacy),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.clickable {  }
        ) {
            Icon(imageVector = Icons.Outlined.Info, contentDescription = null)

            Text(
                text = stringResource(R.string.about),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
    WaxingBeansKenyaTheme {
        AccountScreen(navController = rememberNavController())
    }
}