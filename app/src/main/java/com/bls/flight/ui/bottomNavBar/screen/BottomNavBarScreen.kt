package com.bls.flight.ui.bottomNavBar.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.bls.flight.ui.bottomNavBar.components.BottomBarItem
import com.bls.flight.ui.bottomNavBar.components.HomeBottomNavigation
import com.bls.flight.ui.home.HomeScreen
import com.bls.flight.ui.profile.screens.ProfileScreen
import com.bls.flight.ui.search.SearchScreen
import com.bls.flight.ui.ticket.screens.TicketScreen
import com.bls.flight.utils.navigator.NavigationProvider
import com.bls.flight.utils.navigator.anim.SlideLeftAnimation
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination(style = SlideLeftAnimation::class)
@Composable
fun BottomNavBarScreen(navigator: NavigationProvider) {
    val (currentBottomTab, setCurrentBottomTab) = rememberSaveable {
        mutableStateOf(BottomBarItem.SEARCH)
    }

    Scaffold(
        bottomBar = {
            HomeBottomNavigation(
                bottomTab = currentBottomTab,
                setCurrentBottomTab = setCurrentBottomTab
            )
        }
    ) { paddingValues ->
        val bottomPadding = paddingValues.calculateBottomPadding()
        val modifier = Modifier.padding(bottom = bottomPadding)
        when (currentBottomTab) {
            BottomBarItem.HOME -> HomeScreen(modifier = modifier, navigator = navigator)
            BottomBarItem.SEARCH -> SearchScreen(modifier = modifier, navigator = navigator)
            BottomBarItem.TICKET -> TicketScreen(modifier = modifier, navigator = navigator)
            BottomBarItem.PROFILE -> ProfileScreen(modifier = modifier, navigator = navigator)
        }
    }
}