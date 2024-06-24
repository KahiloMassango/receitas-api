package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Int,
    val titlo: String,
    val descricao: String,
    val tempoDePreparo: Int,
    val unidadeDeTempo: String,
    val porcoes: Int,
    val unidadePorcoes: String,
    val ingredientes: List<Ingredient>,
    val instrucoes: List<Instruction>,
    val criadoEm: String,
    val updatedEm: String,
    val cover: String,
    val autor: String,
    val categoria: Category
)

@Serializable
data class Category(
    val id: Int,
    val nome: String
)

@Serializable
data class Ingredient(
    val nome: String,
    val quantidade: Double,
    val unidade: String,
)

@Serializable
data class Instruction(
    val passo: Int,
    val descricao: String,
)

