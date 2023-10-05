package com.bls.flight.utils.navigator

import com.bls.flight.ui.destinations.LoginScreenDestination
import com.bls.flight.ui.destinations.OnBoardingScreenDestination
import com.bls.flight.ui.destinations.RegisterScreenDestination
import com.bls.flight.ui.destinations.ResetPasswordScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class AppNavigationProvider(private val navController: DestinationsNavigator) : NavigationProvider {
    override fun navigateBack() {
        navController.navigateUp()
    }

    override fun navigateToOnBoardingScreen() {
        navController.navigate(OnBoardingScreenDestination)
    }

    override fun navigateToLoginScreen() {
        navController.navigate(LoginScreenDestination)
    }

    override fun navigateToRegisterScreen() {
        navController.navigate(RegisterScreenDestination)
    }

    override fun navigateToResetPasswordScreen() {
        navController.navigate(ResetPasswordScreenDestination)
    }
}