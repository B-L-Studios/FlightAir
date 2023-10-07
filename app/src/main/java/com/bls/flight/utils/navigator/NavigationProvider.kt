package com.bls.flight.utils.navigator

interface NavigationProvider {
    fun navigateBack()
    fun navigateToOnBoardingScreen()
    fun navigateToLoginScreen()
    fun navigateToRegisterScreen()
    fun navigateToResetPasswordScreen()
    fun navigateToOtpScreen()
    fun navigateToNewPasswordScreen()
    fun openSuccessDialog(image:Int, title:String, description:String, route:String)
    fun navigateWithRoute(route:String)
    fun navigateToMainScreen()
}