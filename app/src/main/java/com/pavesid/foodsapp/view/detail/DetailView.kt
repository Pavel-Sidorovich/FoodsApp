package com.pavesid.foodsapp.view.detail

import com.pavesid.foodsapp.model.Meals

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun setMeal(meal: Meals.Meal?)
    fun onErrorLoading(message: String?)
}