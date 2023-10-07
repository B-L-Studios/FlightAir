package com.bls.flight.ui.home.data

import com.bls.flight.R

data class Flight(
    val airlineAsset: Int,
    val airlineName: String,
    val price: String,
    val departureTime: String,
    val departureGate: String,
    val departureAirport: String,
    val date: String,
    val arrivalTime: String,
    val arrivalGate: String,
    val arrivalAirport: String
)

val listOfFlights = listOf(
    Flight(
        airlineAsset = R.drawable.qatar,
        airlineName = "Qatar Airways",
        price = "$1400",
        departureTime = "10:00 am",
        arrivalTime = "12:00 pm",
        date = "01.10.2023",
        departureGate = "DIA",
        arrivalGate = "SXF",
        departureAirport = "Qatar, QA",
        arrivalAirport = "Berlin, DE",
    ),
    Flight(
        airlineAsset = R.drawable.qantas,
        airlineName = "Qantas",
        price = "$999",
        departureTime = "05:45 am",
        arrivalTime = "08:30 pm",
        date = "05.10.2023",
        departureGate = "DXB",
        arrivalGate = "AKL",
        departureAirport = "Dubai, UAE",
        arrivalAirport = "Auckland, NZ",
    )
)