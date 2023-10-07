package com.bls.flight.ui.ticket.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.bls.flight.ui.ticket.data.Ticket
import com.bls.flight.utils.navigator.NavigationProvider

@Composable
fun TicketItem(ticket: Ticket,navigator:NavigationProvider) {
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
                    painter = painterResource(id = ticket.airlineAsset),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = ticket.airlineName,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                )
            }

            Text(
                text = ticket.airplaneName,
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
                    text = ticket.departureTime,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.LightGray,
                        fontFamily = FontFamily(Font(R.font.poppins_light))
                    )
                )

                Text(
                    text = ticket.departureGate,
                    style = TextStyle(
                        fontSize = 26.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                )

                Text(
                    text = ticket.departureAirport,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins))
                    )
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = ticket.date,
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
                    text = ticket.arrivalTime,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.LightGray,
                        fontFamily = FontFamily(Font(R.font.poppins_light))
                    )
                )

                Text(
                    text = ticket.arrivalGate,
                    style = TextStyle(
                        fontSize = 26.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                )

                Text(
                    text = ticket.arrivalAirport,
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

        if(ticket.isCancelled){
            FlightButton(
                text = "View Details",
                onClick = { navigator.navigateToBoardingPassScreen() },
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            )
        } else {
            Row {
                OutlinedFlightButton(
                    text = "View Details",
                    onClick = { navigator.navigateToBoardingPassScreen() },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                )

                FlightButton(
                    text = if(ticket.isCompleted) "View Invoice" else "Cancel Ticket",
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                )
            }
        }

    }
}