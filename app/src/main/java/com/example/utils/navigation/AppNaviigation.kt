package com.example.utils.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movie.feature.home.presentation.screen.HomeScreen
import com.example.movie.feature.home.presentation.screen.VideoDetailsScreen
import com.example.movie.feature.search.presentation.screen.SearchScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable(
            "movie_details{videoId}",
            arguments = listOf(
                navArgument("videoId") {
                    type = NavType.StringType
                }
            )
        ) {
            val videoId = it.arguments?.getString("videoId") ?: ""
            VideoDetailsScreen(navHostController = navController, videoId)
        }
        composable("search") {
            SearchScreen(navHostController = navController)
        }
    }
}