package com.bls.flight.ui.ticket.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.shared.FlightButton
import com.bls.flight.ui.shared.OutlinedFlightButton
import com.bls.flight.utils.navigator.NavigationProvider

@Composable
fun UpcomingScreen(navigator: NavigationProvider) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}

@Composable
fun TicketItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Qatar Airways",
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

        Spacer(modifier = Modifier.height(16.dp))

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
                    text = "07-10-23",
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

        Row {
            OutlinedFlightButton(
                text = "View Details",
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )

            FlightButton(
                text = "Cancel Ticket",
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )
        }
    }
}

data class TicketInfo(
    val airlineAsset: Int,
    val airlineName: String,
    val airplaneName: String,
    val departureTime: String,
    val arrivalTime: String,
    val date: String,
    val departureGate: String,
    val arrivalGate: String,
    val departureAirport: String,
    val arrivalAirport: String,
)