package com.bls.flight.ui.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun RegisterScreen(navigator: NavigationProvider) {
    val focusNode = LocalFocusManager.current
    val name = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
            )
        }

        Text(
            text = "Register Now!",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            )
        )

        Text(
            text = "Enter your information below",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                color = Color.LightGray,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
        )

        AuthTextField(
            textValue = name,
            placeholder = "Enter Name",
            leadingIcon = R.drawable.outline_person_24,
            imeAction = ImeAction.Next,
            focusNode = focusNode
        )

        AuthTextField(
            textValue = phone,
            placeholder = "Enter Phone Number",
            leadingIcon = R.drawable.outline_phone_24,
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Next,
            focusNode = focusNode
        )

        AuthTextField(
            textValue = email,
            placeholder = "Enter Email",
            leadingIcon = R.drawable.outline_email_24,
            imeAction = ImeAction.Next,
            focusNode = focusNode
        )

        AuthTextField(
            textValue = password,
            placeholder = "Enter Password",
            leadingIcon = R.drawable.outline_lock_24,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            focusNode = focusNode,
            visualTransformation = PasswordVisualTransformation('*')
        )

        FlightButton(
            modifier = Modifier.padding(top = 16.dp),
            text = "Register",
            onClick = { /*TODO*/ }
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Already a member?",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins))
                ),
            )

            TextButton(
                onClick = { navigator.navigateBack() },
                contentPadding = PaddingValues(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        color = Color(0xFF93155b),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins))
                    )
                )
            }
        }
    }
}