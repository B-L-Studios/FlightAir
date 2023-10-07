package com.bls.flight.ui.ticket.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bls.flight.ui.ticket.components.TicketItem
import com.bls.flight.ui.ticket.data.listOfCompletedTickets
import com.bls.flight.utils.navigator.NavigationProvider

@Composable
fun CompletedScreen(navigator: NavigationProvider) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(listOfCompletedTickets) { ticket ->
            TicketItem(ticket = ticket)
        }
    }
}