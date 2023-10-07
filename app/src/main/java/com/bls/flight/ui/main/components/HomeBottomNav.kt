package com.bls.flight.ui.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun HomeBottomNavigation(
    bottomTab: BottomBarItem,
    setCurrentBottomTab: (BottomBarItem) -> Unit
) {
    val pages = BottomBarItem.values()

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {
        pages.forEach { page ->
            val selected = page == bottomTab
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = page.icon),
                        contentDescription = null,
                    )
                },
                alwaysShowLabel = false,
                selected = selected,
                onClick = {
                    setCurrentBottomTab.invoke(page)
                },
                modifier = Modifier.navigationBarsPadding(),
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF93155b),
                    unselectedIconColor = Color.Black,
                    indicatorColor = Color.White
                )
            )
        }
    }
}