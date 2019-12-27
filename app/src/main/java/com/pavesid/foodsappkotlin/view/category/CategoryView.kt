package com.pavesid.foodsappkotlin.view.category

import com.pavesid.foodsappkotlin.model.Meals

interface CategoryView {
    fun showLoading()
    fun hideLoading()
    fun setMeals(meal: List<Meals.Meal>?)
    fun onErrorLoading(message: String?)
}