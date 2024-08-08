package com.example.odmsampleui.ui.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.odmsampleui.R
import com.example.odmsampleui.ui.Constants.Screens

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    var mobileNumber by remember { mutableStateOf(" ") }
    val isButtonEnabled by derivedStateOf { mobileNumber.length >=10 }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(colorResource(id = R.color.color_accent)),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = stringResource(id = R.string.person_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.enter_your_mobile_number_to_get_OTP),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = mobileNumber,
                onValueChange = { newValue ->
                    mobileNumber = newValue
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp)
                    ) {
                        Text(
                            text = "+91",
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.secondary),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .background(color = colorResource(id = R.color.grey))
                        )
                    }
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.enter_your_mobile_number_to_get_OTP),
                        color = colorResource(id = R.color.secondary)
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_phone_number),
                        color = colorResource(id = R.color.secondary),
                        fontSize = 16.sp
                    )
                },
                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = colorResource(id = R.color.secondary),
                    cursorColor = colorResource(id = R.color.secondary),
                    focusedBorderColor = colorResource(id = R.color.secondary)
                )
            )
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ){
                Button(
                    onClick = { navController.navigate(Screens.SERVICESCREEN) },
                    enabled = isButtonEnabled,
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.color_accent)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Continue",
                        fontSize = 20.sp,
                        color = Color.White,)
                }
                Spacer(modifier = Modifier.height(10.dp))
                TermsAndConditionsText()
            }
        }
    }
}

@Composable
fun TermsAndConditionsText(){
    val annotatedString = buildAnnotatedString {
        append("By Clicking, I accept the")
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.color_accent)
            )
        ){
            append(" terms of service")
        }
        append(" and")
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.color_accent)
            )
        ){
            append(" terms of service")
        }
    }
    Text(text = annotatedString,
        fontSize = 12.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
        color = Color.DarkGray)
}


@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}