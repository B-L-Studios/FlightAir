package com.bls.flight.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.shared.AuthTextField
import com.bls.flight.ui.shared.FlightButton
import com.bls.flight.utils.navigator.NavigationProvider

@Composable
fun SearchScreen(modifier: Modifier, navigator: NavigationProvider) {
    val focusNode = LocalFocusManager.current
    val from = remember { mutableStateOf("") }
    val to = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val passenger = remember { mutableStateOf("") }
    val fClass = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(color = Color(0xFF93155b))
                .statusBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Search",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Find your next flight",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.poppins))
                    )
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            AuthTextField(
                textValue = from,
                placeholder = "From",
                leadingIcon = R.drawable.outline_lock_24,
                imeAction = ImeAction.Next,
                focusNode = focusNode
            )

            AuthTextField(
                textValue = to,
                placeholder = "To",
                leadingIcon = R.drawable.outline_lock_24,
                imeAction = ImeAction.Next,
                focusNode = focusNode
            )

            AuthTextField(
                textValue = date,
                placeholder = "Date",
                leadingIcon = R.drawable.outline_lock_24,
                imeAction = ImeAction.Next,
                focusNode = focusNode
            )

            Row {
                AuthTextField(
                    textValue = passenger,
                    placeholder = "Passenger",
                    leadingIcon = R.drawable.outline_lock_24,
                    imeAction = ImeAction.Next,
                    focusNode = focusNode,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(16.dp))

                AuthTextField(
                    textValue = fClass,
                    placeholder = "Class",
                    leadingIcon = R.drawable.outline_lock_24,
                    imeAction = ImeAction.Done,
                    focusNode = focusNode,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            FlightButton(
                onClick = { navigator.navigateToFlightResultScreen() },
                text = "Search Flight",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}