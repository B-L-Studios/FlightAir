package com.bls.flight.utils.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun FlightComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    val systemUiController = rememberSystemUiController()

    val window = (view.context as Activity).window
    WindowCompat.setDecorFitsSystemWindows(window, false)
    systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = !darkTheme)

    MaterialTheme(
        content = content
    )

}