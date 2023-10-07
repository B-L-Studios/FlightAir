package com.bls.flight.utils.navigator

import com.bls.flight.ui.destinations.BottomNavBarScreenDestination
import com.bls.flight.ui.destinations.EditScreenDestination
import com.bls.flight.ui.destinations.LoginScreenDestination
import com.bls.flight.ui.destinations.NewPasswordScreenDestination
import com.bls.flight.ui.destinations.OTPScreenDestination
import com.bls.flight.ui.destinations.OnBoardingScreenDestination
import com.bls.flight.ui.destinations.PaymentMethodScreenDestination
import com.bls.flight.ui.destinations.PrivacyScreenDestination
import com.bls.flight.ui.destinations.RegisterScreenDestination
import com.bls.flight.ui.destinations.ResetPasswordScreenDestination
import com.bls.flight.ui.destinations.SuccessDialogDestination
import com.bls.flight.ui.destinations.TermScreenDestination
import com.bls.flight.ui.destinations.VoucherScreenDestination
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

    override fun navigateToOtpScreen() {
        navController.navigate(OTPScreenDestination)
    }

    override fun navigateToNewPasswordScreen() {
        navController.navigate(NewPasswordScreenDestination)
    }

    override fun openSuccessDialog(image:Int, title:String, description:String, route:String) {
        navController.navigate(
            SuccessDialogDestination(
                image = image,
                title = title,
                description = description,
                route = route
            )
        )
    }

    override fun navigateWithRoute(route: String) {
        navController.navigate(route)
    }

    override fun navigateToMainScreen() {
        navController.navigate(BottomNavBarScreenDestination)
    }

    override fun navigateToEditProfileScreen() {
        navController.navigate(EditScreenDestination)
    }

    override fun navigateToVouchersScreen() {
        navController.navigate(VoucherScreenDestination)
    }

    override fun navigateToPrivacyScreen() {
        navController.navigate(PrivacyScreenDestination)
    }

    override fun navigateToTermsScreen() {
        navController.navigate(TermScreenDestination)
    }

    override fun navigateToPaymentMethodScreen() {
        navController.navigate(PaymentMethodScreenDestination)
    }
}