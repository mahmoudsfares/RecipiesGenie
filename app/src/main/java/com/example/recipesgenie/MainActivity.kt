package com.example.recipesgenie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.recipesgenie.navigation.NavGraph
import com.example.recipesgenie.ui.theme.RecipesGenieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipesGenieTheme {
                NavGraph()
            }
        }
    }
}