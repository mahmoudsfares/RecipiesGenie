package com.example.recipesgenie.presentation.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.recipesgenie.data.recipes
import com.example.recipesgenie.navigation.Navigation
import com.example.recipesgenie.ui.theme.dimens

@Composable
fun RecipesScreen(navController: NavHostController?) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("All recipes", fontSize = MaterialTheme.typography.labelLarge.fontSize, modifier = Modifier.padding(all = MaterialTheme.dimens.sixteen))
            LazyColumn {
                items(recipes) { recipe ->
                    RecipeListItem(recipe, onClick = { id ->
                        navController!!.navigate(
                            Navigation.RecipeDetailsScreen.getRouteWithArguments(id)
                        )
                    })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesScreenPreviewLight() {
    RecipesScreen(null)
}