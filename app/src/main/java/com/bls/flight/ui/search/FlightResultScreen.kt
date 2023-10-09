package com.bls.flight.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.home.components.FlightItem
import com.bls.flight.ui.home.data.listOfFlights
import com.bls.flight.utils.navigator.NavigationProvider
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun FlightResultScreen(navigator: NavigationProvider) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Search Flight",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.navigateBack() }) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowLeft,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF93155b),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        containerColor = Color.White,
    ) { paddingValues ->
        val modifier = Modifier.padding(paddingValues)
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .background(Color(0xFF93155b))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Dubai",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )
                        Text(
                            text = "DXB",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.plane_anim),
                            contentDescription = null
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Auckland",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )
                        Text(
                            text = "AKL",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }
                }
            }

            LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                items(listOfFlights) { flight ->
                    FlightItem(flight = flight, onClick = { /*TODO*/ }, showPrice = true)
                }
            }
        }
    }
}