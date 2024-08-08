package com.example.odmsampleui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.odmsampleui.ui.Constants.Screens
import com.example.odmsampleui.ui.Screens.LoginScreen
import com.example.odmsampleui.ui.Screens.ServiceScreen
import com.example.odmsampleui.ui.Screens.SplashScreen
import com.example.odmsampleui.ui.theme.ODMSampleUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Screens.SPLASHSCREEN) {
                composable(Screens.SPLASHSCREEN){
                    SplashScreen(navController)
                }
                composable(Screens.LOGINSCREEN){
                    LoginScreen(navController)
                }
                composable(Screens.SERVICESCREEN){
                    ServiceScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   SplashScreen(rememberNavController())
}