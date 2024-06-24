package com.example.db

import com.example.models.Category
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object CategoriesTable : IntIdTable("categories") {
    val name = varchar("name", 255)
}

class CategoryDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CategoryDAO>(CategoriesTable)

    var name by CategoriesTable.name

    fun toCategory(): Category = Category(id.value, name)
}



