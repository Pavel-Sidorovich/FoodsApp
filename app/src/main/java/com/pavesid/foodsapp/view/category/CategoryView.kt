package com.pavesid.foodsapp.view.category

import com.pavesid.foodsapp.model.Meals

interface CategoryView {
    fun showLoading()
    fun hideLoading()
    fun setMeals(meal: List<Meals.Meal>?)
    fun onErrorLoading(message: String?)
}