package com.pavesid.foodsapp

import com.pavesid.foodsapp.api.FoodApi
import com.pavesid.foodsapp.api.FoodClient

object Common {
//    val API_Key = "e12c0f8e3cd048c5a993cd3a53c1d398"
    val newClient: FoodApi
        get() = FoodClient().getClient().create(FoodApi::class.java)
}