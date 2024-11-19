package com.example.recipesgenie.presentation.recipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipesgenie.data.Recipe
import com.example.recipesgenie.data.recipes
import com.example.recipesgenie.ui.theme.dimens

@Composable
fun RecipeListItem(recipe: Recipe, onClick: (Int) -> Unit) {
    Box(Modifier.padding(all = dimens.eight)) {
        Card {
            Row(modifier = Modifier
                .clickable {
                    onClick(recipe.id)
                }
                .run {
                    if (LocalConfiguration.current.screenWidthDp < 600) {
                        fillMaxWidth()
                    } else {
                        fillMaxWidth(0.75f)
                    }
                }
            ) {
                Text(
                    text = recipe.name,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(all = dimens.sixteen)
                )
                Image(
                    painter = painterResource(id = recipe.imageResource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(all = dimens.sixteen)
                        .size(dimens.sixtyFour)
                )
            }
        }
    }
}

@Preview
@Composable
fun RecipeListItemPreview() {
    RecipeListItem(recipes[0], {})
}