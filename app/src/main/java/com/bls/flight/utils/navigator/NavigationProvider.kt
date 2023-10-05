package com.bls.flight.utils.navigator

interface NavigationProvider {
    fun navigateBack()
    fun navigateToOnBoardingScreen()
    fun navigateToLoginScreen()
    fun navigateToRegisterScreen()
}