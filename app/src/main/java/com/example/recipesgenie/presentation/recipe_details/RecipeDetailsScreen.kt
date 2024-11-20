package com.example.recipesgenie.presentation.recipe_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.recipesgenie.data.recipes
import com.example.recipesgenie.ui.theme.CompactMediumDimens
import com.example.recipesgenie.ui.theme.LocalAppDimens
import com.example.recipesgenie.ui.theme.dimens

@Composable
fun RecipeDetailsScreen(navController: NavHostController?) {

    val recipe = remember {
        val arguments = navController!!.currentBackStackEntry?.arguments
        val id = arguments?.getInt("id")
        val recipe = recipes[id!!]
        mutableStateOf(recipe)
    }

    val scrollState = rememberScrollState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(recipe.value.imageResource),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxWidth(
                    if (LocalAppDimens.current == CompactMediumDimens) {
                        1f
                    } else  {
                        0.75f
                    }
                ).aspectRatio(1f)
            )
            Column(
                Modifier
                    .padding(horizontal = dimens.sixteen)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    recipe.value.name,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = dimens.sixteen)
                )
                Spacer(modifier = Modifier.height(dimens.twelve))
                Text(
                    "Description:",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(dimens.twelve))
                Text(
                    recipe.value.description,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
                Spacer(modifier = Modifier.height(dimens.sixteen))
                Text(
                    "Ingredients:",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(dimens.twelve))
                Column {
                    recipe.value.ingredients.forEach { ingredient ->
                        Text(
                            "- $ingredient",
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize
                        )
                        Spacer(modifier = Modifier.height(dimens.eight))
                    }
                }
                Spacer(modifier = Modifier.height(dimens.sixteen))
                Text(
                    "How to prepare:",
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(dimens.twelve))
                Column {
                    recipe.value.steps.forEach { step ->
                        Text("- $step", fontSize = MaterialTheme.typography.bodyMedium.fontSize)
                        Spacer(modifier = Modifier.height(dimens.eight))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailsScreenPreviewLight() {
    RecipeDetailsScreen(null)
}
