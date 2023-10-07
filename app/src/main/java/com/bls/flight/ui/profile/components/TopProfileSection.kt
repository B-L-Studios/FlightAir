package com.bls.flight.ui.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R

@Composable
fun TopProfileSection(name: String, email: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(color = Color(0xFF93155b))
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "My Profile",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ProfilePic(borderColor = Color.White)

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = name,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                    )

                    Text(
                        text = email,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_light))
                        )
                    )
                }
            }
        }
    }
}