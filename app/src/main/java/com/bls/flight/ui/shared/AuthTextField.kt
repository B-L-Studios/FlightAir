package com.bls.flight.ui.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    textValue: MutableState<String>,
    placeholder: String,
    leadingIcon: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
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
            keyboardType = keyboardType,
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