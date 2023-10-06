package com.bls.flight.ui.bottomNavBar.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
            .navigationBarsPadding()
    ) {
        pages.forEach { page ->
            val selected = page == bottomTab
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = page.icon),
                        contentDescription = null
                    )
                },
                alwaysShowLabel = false,
                selected = selected,
                onClick = {
                    setCurrentBottomTab.invoke(page)
                },
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}