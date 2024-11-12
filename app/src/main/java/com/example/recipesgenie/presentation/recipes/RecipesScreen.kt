package com.example.recipesgenie.presentation.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.recipesgenie.data.recipes
import com.example.recipesgenie.navigation.Navigation

@Composable
fun RecipesScreen(navController: NavHostController?) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("All recipes", fontSize = 32.sp, modifier = Modifier.padding(all = 16.dp))
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