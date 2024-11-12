package com.example.recipesgenie.data

import com.example.recipesgenie.R

data class Recipe(
    val id: Int,
    val name: String,
    val imageResource: Int,
    val description: String,
    val ingredients: List<String>,
    val steps: List<String>
)

val recipes: List<Recipe> = listOf(
    Recipe(
        id = 0,
        name = "Chicken BBQ",
        imageResource = R.drawable.chicken_bbq,
        description = "Grilled chicken breasts cooked in BBQ sauce",
        ingredients = listOf(
            "4 chicken breasts without bones or skin",
            "Olive oil",
            "Salt",
            "Black pepper",
            "1/2 a cup of BBQ sauce",
        ),
        steps = listOf(
            "Pre-heat the grill",
            "Brush the chicken breasts with olive oil",
            "Season the breasts with salt and black pepper",
            "Put the chicken on the heated grill",
            "Cover the grill and cook for 5-6 minutes or till it can be easily moved on the grill",
            "Turn the breasts on the other side and cook for another 4-5 minutes",
            "Brush the breasts with the BBQ sauce",
            "Turn and cook the chicken for 2 minutes and repeat till it's cooked",
            "Move in a plate and cover with aluminum papers and let it rest for 5 minutes",
            "Serve with more BBQ sauce",
        )
    ),
    Recipe(
        id = 1,
        name = "Chicken Mustard",
        imageResource = R.drawable.chicken_mustard,
        description = "Sauteed chicken breasts cooked with honey and mustard",
        ingredients = listOf(
            "4 chicken breasts without bones or skin",
            "1 teaspoon of salt",
            "1/2 teaspoon of black pepper",
            "2 tablespoons of butter",
            "3 cloves of minced garlic",
            "2 tablespoons of honey",
            "3 tablespoons of mustard",
            "1 lemon juice",
            "1 tablespoon of parsley",
        ),
        steps = listOf(
            "Season the breasts with salt and black pepper",
            "Put the butter to melt in the pan over medium heat",
            "Put the chicken in the pan for 5-7 minutes for each side till it's gold then put it aside",
            "In the same pan, add the garlic and stir for 1-2 minutes till you can smell it",
            "Add the honey, mustard and lemon juice and stir well",
            "Cook on low heat for 2-3 minutes",
            "Get the chicken back in the pan and cover it with the sauce",
            "Cook the mix for 2-3 minutes",
            "Serve hot and decorate with the parsley",
        )
    )
)