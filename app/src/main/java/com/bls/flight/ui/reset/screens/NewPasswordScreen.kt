package com.bls.flight.ui.reset.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
fun NewPasswordScreen(navigator: NavigationProvider) {
    val focusNode = LocalFocusManager.current
    val password = remember { mutableStateOf("") }
    val confirm = remember { mutableStateOf("") }

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
            text = "Enter New Password",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        Image(
            painter = painterResource(id = R.drawable.lock_3d),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        AuthTextField(
            textValue = password,
            placeholder = "Enter new password",
            leadingIcon = R.drawable.outline_lock_24,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation('*'),
            focusNode = focusNode
        )

        AuthTextField(
            textValue = confirm,
            placeholder = "Confirm password",
            leadingIcon = R.drawable.outline_lock_24,
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation('*'),
            focusNode = focusNode
        )

        Spacer(modifier = Modifier.weight(1f))

        FlightButton(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Save",
            onClick = {
                navigator.openSuccessDialog(
                    image = R.drawable.like_3d,
                    title = "Password Updated Successfully",
                    description = "Your password has been updated successfully",
                    route = "login_screen"
                )
            }
        )
    }
}