package com.bls.flight.utils.navigator

import com.bls.flight.ui.destinations.OnBoardingScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class AppNavigationProvider(private val navController: DestinationsNavigator) : NavigationProvider {
    override fun navigateBack() {
        navController.navigateUp()
    }

    override fun navigateToOnBoardingScreen() {
        navController.navigate(OnBoardingScreenDestination)
    }
}