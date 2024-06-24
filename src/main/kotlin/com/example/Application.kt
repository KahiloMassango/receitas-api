package com.example

import com.example.controllers.recipeController
import com.example.db.configureDatabases
import com.example.repositories.RecipeRepositoryImpl
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val recipeRepository = RecipeRepositoryImpl()

    recipeController(recipeRepository)
    configureDatabases()

    install(ContentNegotiation) {
        json()
    }
}
