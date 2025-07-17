package com.example.summerpractice.util

import com.example.summerpractice.R
import com.example.summerpractice.model.CatModel

object CatGenerator {
    private val titles = listOf("First", "Second", "Third", "Fourth", "Fifth", "Sixth")
    private val descriptions = listOf(
        "First cat description",
        "Second cat description",
        "Third cat description",
        "Fourth cat description",
        "Fifth cat description",
        "Sixth cat description"
    )
    private val images = listOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6
    )

    fun generateCats(count: Int): List<CatModel> {
        return List(count) { index ->
            CatModel(
                id = index + 1,
                title = "${titles.random()} cat sample",
                description = descriptions.random(),
                imageResId = images.random()
            )
        }
    }

    fun getRandomImage(): Int = images.random()
}