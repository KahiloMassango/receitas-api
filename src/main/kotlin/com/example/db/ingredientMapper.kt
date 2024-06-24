package com.example.db

import com.example.db.CategoryDAO.Companion.referrersOn
import com.example.models.Ingredient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object IngredientsTable : IntIdTable("ingredients") {
    val name = varchar("name", 255)
    val quantity = double("quantity")
    val unit = varchar("unit", 255)
    val recipeId = reference("recipe_id", RecipesTable)
}

class IngredientDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<IngredientDAO>(IngredientsTable)

    var name by IngredientsTable.name
    var quantity by IngredientsTable.quantity
    var unit by IngredientsTable.unit

    fun toIngredient(): Ingredient = Ingredient(
        name,
        quantity,
        unit,
    )
}