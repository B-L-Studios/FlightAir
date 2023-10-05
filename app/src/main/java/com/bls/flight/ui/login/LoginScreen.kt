package com.bls.flight.ui.login

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.login.components.SocialButton
import com.bls.flight.ui.shared.AuthTextField
import com.bls.flight.ui.shared.FlightButton
import com.bls.flight.utils.navigator.NavigationProvider
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun LoginScreen(navigator: NavigationProvider) {
    val focusNode = LocalFocusManager.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 16.dp),
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
            text = "Login to your account",
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
            imeAction = ImeAction.Done,
            focusNode = focusNode,
            visualTransformation = PasswordVisualTransformation('*')
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            TextButton(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp),

                ) {
                Text(
                    text = "Forgot password?",
                    style = TextStyle(
                        color = Color(0xFF93155b),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_light))
                    )
                )
            }
        }

        FlightButton(
            modifier = Modifier.padding(top = 16.dp),
            text = "Login",
            onClick = { /*TODO*/ }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier.weight(1f),
                thickness = 0.5.dp,
                color = Color.LightGray
            )
            Text(
                text = "  Or continue with  ",
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialButton(
                text = "Google",
                onClick = { /*TODO*/ },
                icon = R.drawable.google
            )

            Spacer(modifier = Modifier.width(22.dp))

            SocialButton(
                text = "Facebook",
                onClick = { /*TODO*/ },
                icon = R.drawable.facebook
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account?",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins))
                ),
            )

            TextButton(
                onClick = { navigator.navigateToRegisterScreen() },
                contentPadding = PaddingValues(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Register Now",
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