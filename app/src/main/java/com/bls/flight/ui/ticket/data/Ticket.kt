package com.bls.flight.ui.ticket.data

import com.bls.flight.R

data class Ticket(
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
    val isCompleted: Boolean,
    val isCancelled: Boolean
)

val listOfUpcomingTickets = listOf(
    Ticket(
        airlineAsset = R.drawable.qatar,
        airlineName = "Qatar Airways",
        airplaneName = "Airbus A320",
        departureTime = "10:00 am",
        arrivalTime = "12:00 pm",
        date = "01.10.2023",
        departureGate = "DIA",
        arrivalGate = "SXF",
        departureAirport = "Qatar, QA",
        arrivalAirport = "Berlin, DE",
        isCompleted = false,
        isCancelled = false
    ),
    Ticket(
        airlineAsset = R.drawable.qantas,
        airlineName = "Qantas",
        airplaneName = "Airbus B350",
        departureTime = "05:45 am",
        arrivalTime = "08:30 pm",
        date = "05.10.2023",
        departureGate = "DXB",
        arrivalGate = "AKL",
        departureAirport = "Dubai, UAE",
        arrivalAirport = "Auckland, NZ",
        isCompleted = false,
        isCancelled = false
    ),
)

val listOfCompletedTickets = listOf(
    Ticket(
        airlineAsset = R.drawable.singapore,
        airlineName = "Singapore Airlines",
        airplaneName = "Airbus A240",
        departureTime = "01:00 pm",
        arrivalTime = "04:00 pm",
        date = "02.10.2023",
        departureGate = "SIN",
        arrivalGate = "LHR",
        departureAirport = "Singapore, SG",
        arrivalAirport = "London, UK",
        isCompleted = true,
        isCancelled = false
    ),
)

val listOfCancelledTickets = listOf(
    Ticket(
        airlineAsset = R.drawable.tunisair,
        airlineName = "Tunisair",
        airplaneName = "Airbus A240",
        departureTime = "08:00 pm",
        arrivalTime = "09:45 pm",
        date = "07.10.2023",
        departureGate = "TOE",
        arrivalGate = "TUN",
        departureAirport = "Tozeur, TN",
        arrivalAirport = "Tunis, TN",
        isCompleted = false,
        isCancelled = true
    ),
)