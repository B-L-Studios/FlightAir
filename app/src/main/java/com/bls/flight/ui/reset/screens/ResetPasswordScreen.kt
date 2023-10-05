package com.bls.flight.ui.reset.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.shared.AuthTextField
import com.bls.flight.ui.shared.FlightButton
import com.bls.flight.utils.navigator.NavigationProvider
import com.bls.flight.utils.navigator.anim.SlideLeftAnimation
import com.ramcosta.composedestinations.annotation.Destination

@Destination(style = SlideLeftAnimation::class)
@Composable
fun ResetPasswordScreen(navigator: NavigationProvider) {
    val focusNode = LocalFocusManager.current
    val email = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        IconButton(
            onClick = { navigator.navigateBack() }
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                contentDescription = "Close"
            )
        }

        Text(
            text = "Forgot Password",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        Text(
            text = "Select which contact details should we use to reset your password",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color.LightGray,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
        )

        Image(
            painter = painterResource(id = R.drawable.lock_3d),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        AuthTextField(
            textValue = email,
            placeholder = "Send OTP via Email",
            leadingIcon = R.drawable.outline_email_24,
            imeAction = ImeAction.Done,
            focusNode = focusNode
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier.weight(1f),
                thickness = 0.5.dp,
                color = Color.LightGray
            )
            Text(
                text = "  Or  ",
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                ),
            )
            Divider(
                modifier = Modifier.weight(1f),
                thickness = 0.5.dp,
                color = Color.LightGray
            )
        }

        AuthTextField(
            textValue = phone,
            placeholder = "Send OTP via Phone",
            leadingIcon = R.drawable.outline_phone_24,
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number,
            focusNode = focusNode
        )

        Spacer(modifier = Modifier.weight(1f))

        FlightButton(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Continue",
            onClick = { navigator.navigateToOtpScreen() }
        )
    }
}