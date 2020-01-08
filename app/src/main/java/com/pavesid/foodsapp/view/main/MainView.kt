package com.pavesid.foodsapp.view.main

import com.pavesid.foodsapp.model.Categories
import com.pavesid.foodsapp.model.Meals

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun setMeal(meal: List<Meals.Meal>?)
    fun setCategory(category: List<Categories.Category>?)
    fun onErrorLoading(message: String?)
}