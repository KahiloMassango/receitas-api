package com.example.db

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.*

fun Application.configureDatabases() {

    Database.connect(
        "jdbc:postgresql://localhost:5432/recipes",
        user = "postgres",
        password = "admin"
    )
}


