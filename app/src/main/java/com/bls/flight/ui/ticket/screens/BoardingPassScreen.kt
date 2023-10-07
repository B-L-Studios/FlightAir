package com.bls.flight.ui.ticket.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.shared.WhiteFlightButton
import com.bls.flight.utils.navigator.NavigationProvider
import com.bls.flight.utils.navigator.anim.SlideFromBottomAnimation
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = SlideFromBottomAnimation::class)
@Composable
fun BoardingPassScreen(navigator: NavigationProvider) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Boarding Pass",
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
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF93155b),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color(0xFF93155b),
    ) { paddingValues ->
        val modifier = Modifier.padding(paddingValues)
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(bottom = 48.dp, top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(horizontal = 16.dp)
            ) {
                /*1 Section*/
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.qatar),
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Qatar Airways",
                            modifier = Modifier.weight(1f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }

                    Text(
                        text = "Airbus A380",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.poppins))
                        )
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    color = Color.LightGray,
                    thickness = 0.6.dp
                )

                /*2 Section*/
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "05:45 pm",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.LightGray,
                                fontFamily = FontFamily(Font(R.font.poppins_light))
                            )
                        )

                        Text(
                            text = "DXB",
                            style = TextStyle(
                                fontSize = 26.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )

                        Text(
                            text = "Dubai, UAE",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "01.10.23",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.LightGray,
                                fontFamily = FontFamily(Font(R.font.poppins_light))
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.plane),
                            contentDescription = null
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "01:05 pm",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.LightGray,
                                fontFamily = FontFamily(Font(R.font.poppins_light))
                            )
                        )

                        Text(
                            text = "AKL",
                            style = TextStyle(
                                fontSize = 26.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )

                        Text(
                            text = "Auckland, NZ",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )
                    }
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    color = Color.LightGray,
                    thickness = 0.6.dp
                )

                /*3 Section*/
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Gate",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "B5",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Passenger",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "1 Adult",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "Flight #",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "AB87",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Class",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "Business",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Seat",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "3C",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "Ticket ID",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "B987098",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Duration",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "22h 20m",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "Bagage",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )

                        Text(
                            text = "20 Kg",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.poppins_bold))
                            )
                        )
                    }
                }

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    color = Color.LightGray,
                    thickness = 0.6.dp
                )

                /*4 Section*/

            }

            WhiteFlightButton(
                onClick = { /*TODO*/ },
                text = "Download Ticket",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }


    }
}