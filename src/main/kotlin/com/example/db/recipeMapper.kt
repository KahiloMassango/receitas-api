package com.example.db

import com.example.models.Category
import com.example.models.Ingredient
import com.example.models.Instruction
import com.example.models.Recipe
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date


object RecipesTable : IntIdTable("recipes") {
    val title = varchar("title", 255)
    val description = text("description")
    val preparationTime = integer("preparation_time")
    val preparationTimeUnit = varchar("preparation_time_unit", 50)
    val servings = integer("servings")
    val servingUnits = varchar("serving_units", 50)
    val createdAt = date("created_at")
    val updatedAt = date("updated_at")
    val cover = varchar("cover", 255)
    val categoryId = integer("category_id")
    val author= varchar("author", 255)
}

class RecipeDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RecipeDAO>(RecipesTable)

    var title by RecipesTable.title
    var description by RecipesTable.description
    var preparationTime by RecipesTable.preparationTime
    var preparationTimeUnit by RecipesTable.preparationTimeUnit
    var servings by RecipesTable.servings
    var servingUnit by RecipesTable.servingUnits
    var createdAt by RecipesTable.createdAt
    var updatedAt by RecipesTable.updatedAt
    var cover by RecipesTable.cover
    val category by RecipesTable.categoryId
    var author by RecipesTable.author


}

fun recipeDaoToModel(
    dao: RecipeDAO,
    category: Category,
    ingredients: List<Ingredient>,
    instruction: List<Instruction>
) : Recipe = Recipe(
    dao.id.value,
    dao.title,
    dao.description,
    dao.preparationTime,
    dao.preparationTimeUnit,
    dao.servings,
    dao.servingUnit,
    ingredients,
    instruction,
    dao.createdAt.toString(),
    dao.updatedAt.toString(),
    dao.cover,
    dao.author,
    category //dao.category
)