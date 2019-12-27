package com.pavesid.foodsappkotlin.view.main

import com.pavesid.foodsappkotlin.model.Categories
import com.pavesid.foodsappkotlin.model.Meals

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun setMeal(meal: List<Meals.Meal>?)
    fun setCategory(category: List<Categories.Category>?)
    fun onErrorLoading(message: String?)
}