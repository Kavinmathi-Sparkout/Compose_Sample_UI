package com.example.odmsampleui.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.odmsampleui.R
import com.example.odmsampleui.ui.Constants.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Screens.LOGINSCREEN)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.color_accent)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_okboz),
            contentDescription = stringResource(id = R.string.logo_name)
        )
    }
}


@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun GreetingPreview() {
    SplashScreen(rememberNavController())
}