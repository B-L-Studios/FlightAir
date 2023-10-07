package com.bls.flight.ui.profile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.utils.navigator.NavigationProvider
import com.bls.flight.utils.navigator.anim.SlideLeftAnimation
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = SlideLeftAnimation::class)
@Composable
fun TermScreen(navigator: NavigationProvider) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Terms & Conditions",
                        style = TextStyle(
                            color = Color.Black,
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
            )
        },
        containerColor = Color.White,
    ) { paddingValues ->
        val modifier = Modifier.padding(paddingValues)
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Last updated: 07/10/2023",
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Please read this Terms & Conditions carefully before using the app operated by B&L Studios.",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins))
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Terms & Conditions",
                style = TextStyle(
                    color = Color(0xFF93155b),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "By downloading or using the app, these terms will automatically apply to you. \n\nYou should make sure therefore that you read them carefully before using the app.\n" +
                        "\nYou’re not allowed to copy, or modify the app, any part of the app, or our trademarks in any way.\n" +
                        "\nYou’re not allowed to attempt to extract the source code of the app, and you also shouldn’t try to translate the app into other languages, or make derivative versions.\n" +
                        "\nThe app itself, and all the trade marks, copyright, database rights and other intellectual property rights related to it, still belong to B&L Studios.",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins))
                )
            )
        }
    }
}