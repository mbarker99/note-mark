package com.mbarker99.notemark.app.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoute {
    @Serializable
    data object Welcome: NavigationRoute

    @Serializable
    data object Login: NavigationRoute

    @Serializable
    data object Register: NavigationRoute
}