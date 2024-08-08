package com.example.odmsampleui.ui.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odmsampleui.R

@Composable
fun ServiceScreen() {
    Scaffold(
        topBar = {
            AppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ChooseYourService()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Choose your service",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.secondary)
                )
                Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            }
        }
    )
}

@Composable
fun ChooseYourService() {
    var selectedServiceId by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Select your service",
            fontSize = 18.sp,
            color = colorResource(id = R.color.secondary)
        )


        /*Card (
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, color = colorResource(id = R.color.color_accent))
        ){
            Row (
                modifier = Modifier
                    .padding(16.dp)
            ){

            }
            
        }*/

        val services = listOf(
            ServiceOption(
                id = 1,
                text = "Delivery Service",
                description = stringResource(id = R.string.streamline),
                image = painterResource(id = R.drawable.ic_delivery)
            ),
            ServiceOption(
                id = 2,
                text = "Transport Service",
                description = stringResource(id = R.string.transport),
                image = painterResource(id = R.drawable.ic_transport)
            )
        )

        services.forEach { service ->

            ServiceCard(
                service = service,
                isSelected = service.id == selectedServiceId,
                onCardClick = {
                    selectedServiceId = service.id
                },
                onRadioButtonClick = {
                    selectedServiceId = service.id
                }
            )
        }
    }
}

@Composable
fun ServiceCard(
    service: ServiceOption,
    isSelected: Boolean,
    onCardClick: () -> Unit,
    onRadioButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .clickable { onCardClick() },
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(
            1.dp,
            color = if (isSelected) colorResource(id = R.color.color_accent) else Color.Gray
        )
    ) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isSelected,
                onClick = onRadioButtonClick,
                colors = RadioButtonDefaults.colors(
                    selectedColor = colorResource(id = R.color.color_accent),
                    unselectedColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.width(1.dp))
            //Row space between
            //Column
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = service.text,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.secondary),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = service.description,
                        fontSize = 12.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = service.image,
                    contentDescription = service.text,
                    modifier = Modifier.size(70.dp),
                    alignment = Alignment.Center
                )
            }
        }
    }
}

data class ServiceOption(
    val id: Int,
    val text: String,
    val description: String,
    val image: Painter
)


@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun ServiceScreenPreview() {
    ServiceScreen()
}