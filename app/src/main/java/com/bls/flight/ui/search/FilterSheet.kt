package com.bls.flight.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.spec.DestinationStyle
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = false)
@Destination(style = DestinationStyle.BottomSheet::class)
@Composable
fun FilterSheet(navigator: NavigationProvider) {
    var sliderValues by remember { mutableStateOf(100f..2000f) }

    val radioOptions = listOf(
        "Non Stop Flights",
        "1 Stop Connecting Flights",
        "All Flights"
    )

    val (selectedRadioOption, onRadioOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    val departureOptions = listOf(
        mapOf(R.drawable.day to "Day"),
        mapOf(R.drawable.night to "Night")
    )

    val (selectedDepartureOption, onDepartureOptionSelected) = remember {
        mutableStateOf(
            departureOptions[0]
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .navigationBarsPadding()
    ) {
        Text(
            text = "Filter",
            modifier = Modifier.padding(vertical = 16.dp),
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        Text(
            text = "Stops",
            modifier = Modifier.padding(bottom = 8.dp),
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        radioOptions.forEach { content ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (content == selectedRadioOption),
                    onClick = {
                        onRadioOptionSelected(content)
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(0xFF93155b),
                        unselectedColor = Color(0xFF93155b).copy(alpha = 0.2f)
                    )
                )

                Text(
                    text = content,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins))
                    )
                )
            }
        }

        Text(
            text = "Departure Time",
            modifier = Modifier.padding(bottom = 8.dp),
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        Row {
            departureOptions.forEach {
                TextButton(
                    onClick = { onDepartureOptionSelected(it) },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = if (it == selectedDepartureOption) {
                            Color(0xFF93155b)
                        } else {
                            Color.Transparent
                        },
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = it.keys.first()),
                            contentDescription = null,
                            colorFilter = if (it == selectedDepartureOption) {
                                ColorFilter.tint(Color.White)
                            } else {
                                ColorFilter.tint(Color.Black)
                            }
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = it.values.first(),
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = if (it == selectedDepartureOption) {
                                    Color.White
                                } else {
                                    Color.Black
                                },
                                fontFamily = FontFamily(Font(R.font.poppins))
                            )
                        )
                    }
                }
            }
        }

        Text(
            text = "Price",
            modifier = Modifier.padding(vertical = 8.dp),
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = sliderValues.start.roundToInt().toString() + " $",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                )
            )
            Text(
                text = sliderValues.endInclusive.roundToInt().toString() + " $",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                )
            )
        }

        RangeSlider(
            value = sliderValues,
            onValueChange = {
                sliderValues = it
            },
            modifier = Modifier.padding(bottom = 16.dp),
            valueRange = 100f..2000f,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF93155b),
                activeTrackColor = Color(0xFF93155b),
                inactiveTrackColor = Color(0xFF93155b).copy(alpha = 0.2f)
            )
        )

        Row {
            OutlinedFlightButton(
                onClick = { navigator.navigateBack() },
                text = "Clear All",
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )
            FlightButton(
                onClick = { navigator.navigateBack() },
                text = "Apply",
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            )
        }
    }
}