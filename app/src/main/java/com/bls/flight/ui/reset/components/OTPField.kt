package com.bls.flight.ui.reset.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R

@Composable
fun OTPField(
    modifier: Modifier = Modifier,
    otp: MutableState<String>,
    focusNode: FocusManager,
    length:Int = 4
) {
    BasicTextField(
        value = TextFieldValue(text = otp.value, selection = TextRange(otp.value.length)),
        onValueChange = {
            if(it.text.length <= length) {
                otp.value = it.text
            }
        },
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusNode.clearFocus()
            }
        ),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.Center) {
                repeat(length) { index ->
                    SingleOTPBox(
                        index = index,
                        text = otp.value
                    )
                }
            }
        }
    )
}

@Composable
private fun RowScope.SingleOTPBox(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index >= text.length -> ""
        else -> text[index].toString()
    }

    Box(
        modifier = Modifier
            .padding(4.dp)
            .border(
                width = when {
                    isFocused -> 2.dp
                    else -> 1.dp
                },
                color = when {
                    isFocused -> Color(0xFF93155b)
                    else -> Color.LightGray
                },
                shape = RoundedCornerShape(18.dp)
            )
            .clip(RoundedCornerShape(18.dp))
            .weight(1f)
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = char,
            style = TextStyle(
                fontSize = 30.sp,
                color = Color(0xFF93155b),
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            ),
            textAlign = TextAlign.Center
        )
    }
}