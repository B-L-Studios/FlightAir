package com.bls.flight.ui.ticket.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.ticket.components.TabItem
import com.bls.flight.utils.navigator.NavigationProvider

@Composable
fun TicketScreen(modifier: Modifier, navigator: NavigationProvider) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Upcoming", "Completed", "Cancelled")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Tickets",
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TabRow(
            selectedTabIndex = tabIndex,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.White,
            indicator = {},
            divider = {},
            tabs = {
                tabs.forEachIndexed { index, title ->
                    TabItem(
                        title = title,
                        onClick = { tabIndex = index },
                        index = index,
                        tabIndex = tabIndex
                    )
                }
            }
        )

        when (tabIndex) {
            0 -> UpcomingScreen(navigator = navigator)
            1 -> CompletedScreen(navigator = navigator)
            2 -> CancelledScreen(navigator = navigator)
        }
    }
}