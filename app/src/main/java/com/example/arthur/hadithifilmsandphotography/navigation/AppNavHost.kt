package com.example.arthur.hadithifilmsandphotography.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.arthur.hadithifilmsandphotography.data.BookingViewModel
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.admin.CustomerBookings
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.bookings.AddBookingScreen
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.bookings.BookingListScreen
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.bookings.EditBookingScreen
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.codeverification.CodeVerification
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.gallery.GalleryScreen
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.login.LoginScreen
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.register.RegisterScreen
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.splash.SplashScreen
import com.example.arthur.hadithifilmsandphotography.ui.theme.screens.userdashboard.DashboardScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {
    val context = LocalContext.current
    val bookingViewModel = BookingViewModel(navController, context)

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_CUSTOMERBOOKINGS) {
            CustomerBookings(navController = navController, viewModel = bookingViewModel)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_CODEVERIFICATION) {
            CodeVerification(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_GALLERY) {
            GalleryScreen(navController)
        }
        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUT_REGISTER) {
            RegisterScreen(navController)
        }

        composable(ROUT_ADD_BOOKING) {
            AddBookingScreen(navController = navController)
        }
        composable(ROUT_VIEW_BOOKING) {
            BookingListScreen(navController = navController)
        }
        composable(
            ROUT_EDIT_BOOKING,
            arguments = listOf(navArgument("bookingId") { type = NavType.StringType })
        ) {
            val bookingId = it.arguments?.getString("bookingId") ?: ""
            EditBookingScreen(navController, bookingId)
        }
    }
}
