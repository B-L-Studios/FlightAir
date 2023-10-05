package com.bls.flight.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun LoginScreen() {
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
                onClick = { /*TODO*/ },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    textValue: MutableState<String>,
    placeholder: String,
    leadingIcon: Int,
    imeAction: ImeAction,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    focusNode: FocusManager
) {
    val keyboardActions = if (imeAction == ImeAction.Next) {
        KeyboardActions(
            onNext = {
                focusNode.moveFocus(FocusDirection.Next)
            }
        )
    } else {
        KeyboardActions(
            onDone = {
                focusNode.clearFocus()
            }
        )
    }
    OutlinedTextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins))
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                )
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = null
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.Transparent,
            focusedBorderColor = Color(0xFF93155b),
            unfocusedBorderColor = Color.LightGray,
            cursorColor = Color(0xFF93155b),
            focusedLeadingIconColor = Color(0xFF93155b),
            unfocusedLeadingIconColor = Color.LightGray,
        )
    )
}

@Composable
fun FlightButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF93155b),
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                letterSpacing = 0.5.sp,
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
        )
    }
}

@Composable
fun RowScope.SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    icon: Int
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.weight(1f),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.White
        ),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.poppins))
                )
            )
        }
    }
}