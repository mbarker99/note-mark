package com.mbarker99.notemark.app.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mbarker99.notemark.auth.presentation.login.LoginScreenRoot
import com.mbarker99.notemark.auth.presentation.register.RegisterScreenRoot
import com.mbarker99.notemark.auth.presentation.welcome.WelcomeScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.Welcome
    ) {
        composable<NavigationRoute.Welcome> {
            WelcomeScreenRoot(
                onNavigateToLogin = {
                    navController.navigate(NavigationRoute.Login)
                },
                onNavigateToRegister = {
                    navController.navigate(NavigationRoute.Register)
                })
        }

        composable<NavigationRoute.Login> {
            LoginScreenRoot(
                onNavigateToRegister = {
                    navController.navigate(NavigationRoute.Register) {
                        popUpTo(navController.graph.findStartDestination().id)
                    }
                }
            )
        }

        composable<NavigationRoute.Register> {
            RegisterScreenRoot(
                onNavigateToLogin = {
                    navController.navigate(NavigationRoute.Login) {
                        popUpTo(navController.graph.findStartDestination().id)
                    }
                }
            )
        }
    }
}