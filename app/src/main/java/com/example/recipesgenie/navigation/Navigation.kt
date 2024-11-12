package com.example.recipesgenie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipesgenie.presentation.recipe_details.RecipeDetailsScreen
import com.example.recipesgenie.presentation.recipes.RecipesScreen

private object RouteNames {
    const val RECIPES = "recipes"
    const val RECIPE_DETAILS = "recipeDetails"
}

sealed class Navigation {
    data object RecipesScreen: Navigation() {
        fun getRoute(): String {
            return RouteNames.RECIPES
        }
    }
    data object RecipeDetailsScreen: Navigation() {
        fun getRouteWithArguments(id: Int): String {
            return RouteNames.RECIPE_DETAILS + "/$id"
        }
    }
}

@Composable
fun NavGraph() {
    // carries out the navigation with commands like navigate, pop,...
    // must be passed to all the screens in which a navigation action will take place
    val navController = rememberNavController()
    // a container for all the destinations in the app
    NavHost(navController = navController, startDestination = Navigation.RecipesScreen.getRoute()) {
        // home screen: initial, no arguments
        composable(route = RouteNames.RECIPES) {
            RecipesScreen(navController = navController)
        }
        composable(
            route = RouteNames.RECIPE_DETAILS + "/{id}",
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) {
            RecipeDetailsScreen(navController)
        }
    }
}

