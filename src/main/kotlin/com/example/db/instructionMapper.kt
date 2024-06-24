package com.example.db

import com.example.models.Instruction
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object InstructionsTable : IntIdTable("instructions") {
    val stepNumber = integer("step_number")
    val description = varchar("description", 255)
    val recipeId = reference("recipe_id", RecipesTable)
}

class InstructionsDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<InstructionsDAO>(InstructionsTable)

    private var stepNumber by InstructionsTable.stepNumber
    private var description by InstructionsTable.description

    fun toInstruction(): Instruction = Instruction(stepNumber, description)
}

