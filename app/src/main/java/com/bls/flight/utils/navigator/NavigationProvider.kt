package com.bls.flight.utils.navigator

interface NavigationProvider {
    fun navigateBack()
    fun navigateToLoginScreen()
    fun navigateToRegisterScreen()
    fun navigateToResetPasswordScreen()
    fun navigateToOtpScreen()
    fun navigateToNewPasswordScreen()
    fun openSuccessDialog(image:Int, title:String, description:String, route:String)
    fun navigateWithRoute(route:String)
    fun navigateToMainScreen()
    fun navigateToEditProfileScreen()
    fun navigateToVouchersScreen()
    fun navigateToPrivacyScreen()
    fun navigateToTermsScreen()
    fun navigateToPaymentMethodScreen()
    fun navigateToBoardingPassScreen()
    fun navigateToFlightResultScreen()
    fun openFilterSheet()
}