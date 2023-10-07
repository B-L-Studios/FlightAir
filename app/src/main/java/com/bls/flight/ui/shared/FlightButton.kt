package com.bls.flight.ui.shared

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R

@Composable
fun FlightButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.textButtonColors(
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
fun WhiteFlightButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color(0xFF93155b),
            containerColor = Color.White
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color(0xFF93155b),
                fontSize = 18.sp,
                letterSpacing = 0.5.sp,
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
        )
    }
}

@Composable
fun OutlinedFlightButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFF93155b),
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.White,
            contentColor = Color(0xFF93155b)
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color(0xFF93155b),
                fontSize = 18.sp,
                letterSpacing = 0.5.sp,
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
        )
    }
}