package com.example.waxingbeanskenya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.waxingbeanskenya.navigation.SetupNavGraph
import com.example.waxingbeanskenya.ui.theme.WaxingBeansKenyaTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaxingBeansKenyaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    WaxingBeansApp(navController = rememberNavController())

                    var navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}


