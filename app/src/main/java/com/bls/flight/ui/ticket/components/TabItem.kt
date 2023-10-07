package com.bls.flight.ui.ticket.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R

@Composable
fun TabItem(title: String, onClick: () -> Unit, index: Int, tabIndex: Int) {
    Tab(
        selected = tabIndex == index,
        onClick = onClick,
        modifier = Modifier.clip(RoundedCornerShape(16.dp)),
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = if (index == tabIndex) Color.White else Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold))
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(if (index == tabIndex) Color(0xFF93155b) else Color.White)
                .padding(16.dp)
        )
    }

}