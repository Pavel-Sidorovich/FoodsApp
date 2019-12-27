package com.pavesid.foodsappkotlin.api


import com.pavesid.foodsappkotlin.model.Categories
import com.pavesid.foodsappkotlin.model.Meals
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("search.php?f=c")
    fun getMeal(): Call<Meals>

    @GET("categories.php")
    fun getCategories(): Call<Categories>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") category: String): Call<Meals>

    @GET("search.php")
    fun getMealByName(@Query("s") mealName: String): Call<Meals>
}