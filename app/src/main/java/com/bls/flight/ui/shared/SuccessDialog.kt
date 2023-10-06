package com.bls.flight.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.bls.flight.R
import com.bls.flight.utils.navigator.NavigationProvider
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(
    style = DestinationStyle.Dialog::class,
    navArgsDelegate = SuccessDialogNavArgsDelegate::class
)
@Composable
fun SuccessDialog(
    navArgs: SuccessDialogNavArgsDelegate,
    navigator: NavigationProvider
) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = navArgs.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = navArgs.title,
                    maxLines = 2,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                )

                Text(
                    text = navArgs.description,
                    maxLines = 2,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins))
                    )
                )

                FlightButton(
                    modifier = Modifier.padding(16.dp),
                    text = "Back To Login",
                    onClick = { navigator.navigateWithRoute(navArgs.route) }
                )
            }
        }
    }
}

data class SuccessDialogNavArgsDelegate(
    val image: Int,
    val title: String,
    val description: String,
    val route:String
)
