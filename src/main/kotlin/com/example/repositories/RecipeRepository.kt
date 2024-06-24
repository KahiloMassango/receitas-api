package com.example.repositories

import com.example.models.Recipe

interface RecipeRepository {

    suspend fun getAllRecipes(): List<Recipe>

    suspend fun getRecipesByCategory(categoryId: Int): List<Recipe>?

    suspend fun getRecipesByTitle(title: String): List<Recipe>

    suspend fun getRecipeById(id: Int): Recipe?
}