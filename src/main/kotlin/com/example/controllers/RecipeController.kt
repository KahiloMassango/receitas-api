package com.example.controllers

import com.example.repositories.RecipeRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.recipeController(recipeRepository: RecipeRepository) {
    routing {
        route("/recipes") {
            get("/") {
                // Get all recipes
                val recipes = recipeRepository.getAllRecipes()
                call.respond(HttpStatusCode.OK, recipes)
            }

            get("/category={categoryId}") {
                // Get recipes by category
                val categoryId = call.parameters["categoryId"] ?: return@get call.response.status(HttpStatusCode.BadRequest)
                try {
                    val recipes = recipeRepository.getRecipesByCategory(categoryId.toInt())
                    if (recipes == null){
                        call.respond(HttpStatusCode.OK, "Categoria não existe")
                    } else {
                        call.respond(HttpStatusCode.OK, recipes)
                    }
                } catch (e: Exception){
                    call.respond(HttpStatusCode.OK, "Categoria inválida")
                }
            }

            get("/title={title}") {
                // Get recipes by title
                val title = call.parameters["title"] ?: return@get call.respond(HttpStatusCode.OK, "Titlo inválido")
                val recipes = recipeRepository.getRecipesByTitle(title)
                call.respond(HttpStatusCode.OK, recipes)

            }

            get("/id={id}") {

                val recipeId = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest, "Id inválido")
                try {
                    val recipe = recipeRepository.getRecipeById(recipeId.toInt())
                    if (recipe == null){
                        call.respond(HttpStatusCode.OK, "Receita não existe")
                    } else {
                        call.respond(HttpStatusCode.OK, recipe)
                    }
                } catch (e: Exception){
                    call.respond(HttpStatusCode.OK, "Id inválido")
                }
            }

            staticFiles("/images", File("src/main/resources/static"))
        }
    }
}

