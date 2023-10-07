package com.bls.flight.ui.profile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bls.flight.R
import com.bls.flight.ui.profile.components.TopProfileSection
import com.bls.flight.ui.shared.FlightButton
import com.bls.flight.utils.navigator.NavigationProvider

@Composable
fun ProfileScreen(modifier: Modifier, navigator: NavigationProvider) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        TopProfileSection(
            name = "Tim Jennings",
            email = "tim.jennings@domain.com"
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ProfileItem(
                onClick = { navigator.navigateToEditProfileScreen() },
                image = R.drawable.edit,
                text = "Edit Profile"
            )

            ProfileItem(
                onClick = { navigator.navigateToVouchersScreen() },
                image = R.drawable.voucher,
                text = "My Vouchers"
            )

            ProfileItem(
                onClick = { navigator.navigateToPaymentMethodScreen() },
                image = R.drawable.payment,
                text = "Payment Methods"
            )

            ProfileItem(
                onClick = { navigator.navigateToPrivacyScreen() },
                image = R.drawable.privacy,
                text = "Privacy Policy"
            )

            ProfileItem(
                onClick = { navigator.navigateToTermsScreen() },
                image = R.drawable.terms,
                text = "Terms & Conditions"
            )

            Spacer(modifier = Modifier.weight(1f))

            FlightButton(
                text = "Logout",
                onClick = {},
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
fun ProfileItem(onClick: () -> Unit, image: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = text,
            modifier = Modifier.weight(1f),
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins))
            )
        )

        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = null,
                tint = Color(0xFF93155b)
            )
        }
    }
}