package com.example.repositories

import com.example.db.*
import com.example.models.Recipe

class RecipeRepositoryImpl: RecipeRepository {
    override suspend fun getAllRecipes(): List<Recipe> = suspendTransaction {
        RecipeDAO
            .all()
            .map { recipeDAO ->
                val category = CategoryDAO.find{ CategoriesTable.id eq recipeDAO.category }.map { it.toCategory() }.first()
                val ingredients = IngredientDAO.find { IngredientsTable.recipeId eq recipeDAO.id }.map { it.toIngredient()}
                val instructions = InstructionsDAO.find {InstructionsTable.recipeId eq recipeDAO.id }.map { it.toInstruction() }
                recipeDaoToModel(recipeDAO, category, ingredients, instructions)
            }

    }

    override suspend fun getRecipesByCategory(categoryId: Int): List<Recipe>? = suspendTransaction {
        val category = CategoryDAO.findById(categoryId)?.toCategory() ?: return@suspendTransaction null
        RecipeDAO
            .find { RecipesTable.categoryId eq categoryId}
            .map { recipeDAO ->
                val ingredients = IngredientDAO.find { IngredientsTable.recipeId eq recipeDAO.id.value }.map { it.toIngredient()}
                val instructions = InstructionsDAO.find {InstructionsTable.recipeId eq recipeDAO.id.value }.map { it.toInstruction() }
                recipeDaoToModel(recipeDAO, category, ingredients, instructions)
            }
    }

    override suspend fun getRecipesByTitle(title: String): List<Recipe> = suspendTransaction {
        RecipeDAO
            .find { RecipesTable.title like "%$title%" }
            .map { recipeDAO ->
                val category = CategoryDAO.find{ CategoriesTable.id eq recipeDAO.category }.map { it.toCategory() }.first()
                val ingredients = IngredientDAO.find { IngredientsTable.recipeId eq recipeDAO.id.value }.map { it.toIngredient()}
                val instructions = InstructionsDAO.find {InstructionsTable.recipeId eq recipeDAO.id.value }.map { it.toInstruction() }
                recipeDaoToModel(recipeDAO, category, ingredients, instructions)
            }
    }

    override suspend fun getRecipeById(id: Int): Recipe? = suspendTransaction {
        RecipeDAO
            .find { RecipesTable.id eq id }
            .limit(1)
            .map { recipeDAO ->
                val category = CategoryDAO.find{ CategoriesTable.id eq recipeDAO.category }.map { it.toCategory() }.first()
                val ingredients = IngredientDAO.find { IngredientsTable.recipeId eq recipeDAO.id }.map { it.toIngredient()}
                val instructions = InstructionsDAO.find {InstructionsTable.recipeId eq recipeDAO.id }.map { it.toInstruction() }
                recipeDaoToModel(recipeDAO, category, ingredients, instructions)
            }
            .firstOrNull()
    }
}