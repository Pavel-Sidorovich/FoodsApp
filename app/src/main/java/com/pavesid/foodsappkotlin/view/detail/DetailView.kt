package com.pavesid.foodsappkotlin.view.detail

import com.pavesid.foodsappkotlin.model.Meals

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun setMeal(meal: Meals.Meal?)
    fun onErrorLoading(message: String?)
}