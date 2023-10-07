package com.bls.flight.ui.bottomNavBar.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.bls.flight.ui.bottomNavBar.components.BottomBarItem
import com.bls.flight.ui.bottomNavBar.components.HomeBottomNavigation
import com.bls.flight.utils.navigator.NavigationProvider
import com.bls.flight.utils.navigator.anim.SlideLeftAnimation
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@OptIn(ExperimentalMaterial3Api::class)
@Destination(style = SlideLeftAnimation::class)
@Composable
fun BottomNavBarScreen(navigator: NavigationProvider) {
    val (currentBottomTab, setCurrentBottomTab) = rememberSaveable {
        mutableStateOf(BottomBarItem.HOME)
    }

    Scaffold(
        bottomBar = {
            HomeBottomNavigation(bottomTab = currentBottomTab, setCurrentBottomTab = setCurrentBottomTab)
        }
    ) { paddingValues ->
        val modifier = Modifier.padding(paddingValues = paddingValues)
        when (currentBottomTab) {
            BottomBarItem.HOME -> HomeScreen(modifier = modifier, navigator = navigator)
            BottomBarItem.SEARCH -> SearchScreen(modifier = modifier, navigator = navigator)
            BottomBarItem.QR -> QRScreen(modifier = modifier, navigator = navigator)
            BottomBarItem.TICKET -> TicketScreen(modifier = modifier, navigator = navigator)
            BottomBarItem.PROFILE -> ProfileScreen(modifier = modifier, navigator = navigator)
        }

    }
}

@Composable
fun HomeScreen(modifier: Modifier, navigator: NavigationProvider) {
    Column(modifier = modifier.fillMaxSize()) {

    }
}

@Composable
fun SearchScreen(modifier: Modifier, navigator: NavigationProvider) {
    Column(modifier = modifier.fillMaxSize()) {

    }
}

@Composable
fun QRScreen(modifier: Modifier, navigator: NavigationProvider) {
    Column(modifier = modifier.fillMaxSize()) {

    }
}

@Composable
fun TicketScreen(modifier: Modifier, navigator: NavigationProvider) {
    Column(modifier = modifier.fillMaxSize()) {

    }
}

@Composable
fun ProfileScreen(modifier: Modifier, navigator: NavigationProvider) {
    Column(modifier = modifier.fillMaxSize()) {

    }
}