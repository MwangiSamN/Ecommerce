package com.example.waxingbeanskenya.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.waxingbeanskenya.R
import com.example.waxingbeanskenya.navigation.Screen
import com.example.waxingbeanskenya.ui.theme.WaxingBeansKenyaTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ProductDetailPage(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBarProduct(navController = navController)
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.ShoppingCart.route)
                }
            ) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = null)
            }
        },

        content = {it
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    ProductImageCarousel()
                }
                Surface(
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 280.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 30.dp)
                    ) {
                        ProductItemTitle()
                        Spacer(modifier = Modifier.height(10.dp))
                        ProductSize()
                        ProductColours()
                        ProductDescription()
                    }
                }
            }
        }
    )


}

@Composable
fun TopAppBarProduct(
    navController: NavController
){
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
            IconButton(onClick = {
                navController.navigate(route = Screen.WaxingShop.route){
                    popUpTo(route = Screen.WaxingShop.route){
                        inclusive = true
                    }
                }
            }) {
                androidx.compose.material3.Icon(
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
            IconButton(onClick = { /*TODO*/ }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surfaceTint
                )

            }
        }
    }
}

@Composable
fun ProductImageCarousel(
    modifier: Modifier = Modifier
){
    val carouselList = listOf(
        R.drawable.rose100,
        R.drawable.lavendar500_2
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentScale = ContentScale.Fit,
            painter = painterResource(id = R.drawable.rose100),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(carouselList.size){
                item ->
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .width(62.dp)
                        .border(
                            color = if (item == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
                            shape = RoundedCornerShape(16.dp),
                            width = 2.dp
                        )
                        .clickable { }
                ) {
                    Image(
                        painter = painterResource(carouselList[item]),
                        contentDescription = null,
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                            .padding(
                                start = 10.dp, top = 5.dp, bottom = 5.dp, end = 5.dp
                            )
                    )
                }
            }

        }
    }
}

@Composable
fun ProductItemTitle(
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .height(4.dp)
                .width(40.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.product_name_1),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Column(modifier = Modifier.wrapContentHeight()) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Kshs ")
                        }
                        withStyle(
                            style = SpanStyle(

                            )
                        ) {
                            append("500")
                        }
                    },
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold

                )


            }
        }
    }
}

@Composable
fun ProductSize(){
    val productWeight = listOf(
        "100g",
        "300g",
        "500g"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Available Weights",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(10.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(productWeight.size){
                item ->
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(80.dp)
                        .border(
                            color = if (item == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary,
                            shape = RoundedCornerShape(10.dp),
                            width = 2.dp
                        )
                        .clickable { }
                ) {
                    Text(
                        modifier = Modifier.padding(
                            start = 20.dp,
                            end = 16.dp,
                            top = 10.dp,
                            bottom = 8.dp
                        ),
                        text = productWeight[item]
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun ProductColours(){

    val productColor = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Colors",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }

    Spacer(modifier = Modifier.padding(10.dp))

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(productColor.size){
            item ->
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
                    .background(productColor[item])
                    .clickable { }
            )
        }
    }
    Spacer(modifier = Modifier.padding(10.dp))
}

@Composable
fun ProductDescription(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Description",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(R.string.product_description_1),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview(){
    WaxingBeansKenyaTheme {
        ProductDetailPage(navController = rememberNavController())
    }
}