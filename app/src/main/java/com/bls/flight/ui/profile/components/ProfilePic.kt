package com.bls.flight.ui.profile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePic(borderColor: Color = Color(0xFF93155b)) {
    Box(
        modifier = Modifier
            .sizeIn(
                minWidth = 100.dp, minHeight = 100.dp, maxWidth = 120.dp, maxHeight = 120.dp
            )
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, borderColor, RoundedCornerShape(8.dp))
    )
}