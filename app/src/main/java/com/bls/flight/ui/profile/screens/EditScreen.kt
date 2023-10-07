package com.bls.flight.ui.profile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.profile.components.ProfilePic
import com.bls.flight.ui.shared.AuthTextField
import com.bls.flight.ui.shared.FlightButton
import com.bls.flight.utils.navigator.NavigationProvider
import com.bls.flight.utils.navigator.anim.SlideLeftAnimation
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = SlideLeftAnimation::class)
@Composable
fun EditScreen(navigator: NavigationProvider) {
    val focusNode = LocalFocusManager.current
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val number = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Edit Profile", style = TextStyle(
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
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfilePic()

            Spacer(modifier = Modifier.height(16.dp))

            AuthTextField(
                textValue = name,
                placeholder = "Tim Jennings",
                leadingIcon = R.drawable.outline_person_24,
                imeAction = ImeAction.Next,
                focusNode = focusNode
            )

            AuthTextField(
                textValue = email,
                placeholder = "tim.jennings@domain.com",
                leadingIcon = R.drawable.outline_email_24,
                imeAction = ImeAction.Next,
                focusNode = focusNode
            )

            AuthTextField(
                textValue = number,
                placeholder = "+1 202 555 0192",
                leadingIcon = R.drawable.outline_phone_24,
                imeAction = ImeAction.Done,
                focusNode = focusNode,
                keyboardType = KeyboardType.Phone
            )

            Spacer(modifier = Modifier.weight(1f))

            FlightButton(
                onClick = {},
                text = "Update",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}