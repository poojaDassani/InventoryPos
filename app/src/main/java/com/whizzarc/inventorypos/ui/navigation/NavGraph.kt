package com.whizzarc.inventorypos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.simplenavigationcompose.ui.screens.HomeScreen
import com.whizzarc.inventorypos.ui.screens.LoginScreen
import com.whizzarc.inventorypos.ui.screens.CustomerModule
import com.whizzarc.inventorypos.ui.screens.SearchScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        composable(route = NavRoute.Login.path) {
            LoginScreen(
                navigateToHome = {
                    navController.navigate(NavRoute.Home.path)
                }
            )
        }
        composable(route = NavRoute.Home.path) {

            HomeScreen(
                navigateToProfile = { id, showDetails ->
                    navController.navigate(NavRoute.Profile.withArgs(id.toString(), showDetails.toString()))
                },
                navigateToSearch = { query ->
                    navController.navigate(NavRoute.Search.withArgs(query))
                },
                popUpToLogin= { popUpToLogin(navController) },
            )
        }

        composable(
            route = NavRoute.Profile.withArgsFormat(NavRoute.Profile.id, NavRoute.Profile.showDetails),
            arguments = listOf(
                navArgument(NavRoute.Profile.id) {
                    type = NavType.IntType
                }
                ,
                navArgument(NavRoute.Profile.showDetails) {
                    type = NavType.BoolType
                }
            )
        ) { navBackStackEntry ->

            val args = navBackStackEntry.arguments

            CustomerModule(
                id = args?.getInt(NavRoute.Profile.id)!!,
                showDetails = args.getBoolean(NavRoute.Profile.showDetails),
                popBackStack = { navController.popBackStack() },
                popUpToLogin = { popUpToLogin(navController) }
            )
        }
        composable(
            route = NavRoute.Search.withArgsFormat(NavRoute.Search.query),
            arguments = listOf(
                navArgument(NavRoute.Search.query) {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { navBackStackEntry ->

            val args = navBackStackEntry.arguments

            SearchScreen(
                query = args?.getString(NavRoute.Search.query),
                popBackStack = { navController.popBackStack() },
                popUpToLogin = { popUpToLogin(navController) }
            )
        }    }
}


private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(NavRoute.Home.path, inclusive = true)
}