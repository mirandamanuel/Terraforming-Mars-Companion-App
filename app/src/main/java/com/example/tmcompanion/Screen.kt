package com.example.tmcompanion

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object AddResourcesScreen : Screen("add_resources_screen")
    object RemoveResourcesScreen : Screen("remove_resources_screen")
}
