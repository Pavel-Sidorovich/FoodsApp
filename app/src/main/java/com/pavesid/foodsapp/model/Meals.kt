package com.pavesid.foodsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Meals: Serializable {
    @SerializedName("meals")
    @Expose
    private var meals: List<Meal>? = null

    fun getMeals(): List<Meal>? {
        return meals
    }

    fun setMeals(meals: List<Meal>) {
        this.meals = meals
    }

    inner class Meal: Serializable {
        @SerializedName("idMeal")
        @Expose
        private var idMeal: String? = null
        @SerializedName("strMeal")
        @Expose
        private var strMeal: String? = null
        @SerializedName("strDrinkAlternate")
        @Expose
        private var strDrinkAlternate: Any? = null
        @SerializedName("strCategory")
        @Expose
        private var strCategory: String? = null
        @SerializedName("strArea")
        @Expose
        private var strArea: String? = null
        @SerializedName("strInstructions")
        @Expose
        private var strInstructions: String? = null
        @SerializedName("strMealThumb")
        @Expose
        private var strMealThumb: String? = null
        @SerializedName("strTags")
        @Expose
        private var strTags: String? = null
        @SerializedName("strYoutube")
        @Expose
        private var strYoutube: String? = null
        @SerializedName("strIngredient1")
        @Expose
        private var strIngredient1: String? = null
        @SerializedName("strIngredient2")
        @Expose
        private var strIngredient2: String? = null
        @SerializedName("strIngredient3")
        @Expose
        private var strIngredient3: String? = null
        @SerializedName("strIngredient4")
        @Expose
        private var strIngredient4: String? = null
        @SerializedName("strIngredient5")
        @Expose
        private var strIngredient5: String? = null
        @SerializedName("strIngredient6")
        @Expose
        private var strIngredient6: String? = null
        @SerializedName("strIngredient7")
        @Expose
        private var strIngredient7: String? = null
        @SerializedName("strIngredient8")
        @Expose
        private var strIngredient8: String? = null
        @SerializedName("strIngredient9")
        @Expose
        private var strIngredient9: String? = null
        @SerializedName("strIngredient10")
        @Expose
        private var strIngredient10: String? = null
        @SerializedName("strIngredient11")
        @Expose
        private var strIngredient11: String? = null
        @SerializedName("strIngredient12")
        @Expose
        private var strIngredient12: String? = null
        @SerializedName("strIngredient13")
        @Expose
        private var strIngredient13: String? = null
        @SerializedName("strIngredient14")
        @Expose
        private var strIngredient14: String? = null
        @SerializedName("strIngredient15")
        @Expose
        private var strIngredient15: String? = null
        @SerializedName("strIngredient16")
        @Expose
        private var strIngredient16: String? = null
        @SerializedName("strIngredient17")
        @Expose
        private var strIngredient17: String? = null
        @SerializedName("strIngredient18")
        @Expose
        private var strIngredient18: String? = null
        @SerializedName("strIngredient19")
        @Expose
        private var strIngredient19: String? = null
        @SerializedName("strIngredient20")
        @Expose
        private var strIngredient20: String? = null
        @SerializedName("strMeasure1")
        @Expose
        private var strMeasure1: String? = null
        @SerializedName("strMeasure2")
        @Expose
        private var strMeasure2: String? = null
        @SerializedName("strMeasure3")
        @Expose
        private var strMeasure3: String? = null
        @SerializedName("strMeasure4")
        @Expose
        private var strMeasure4: String? = null
        @SerializedName("strMeasure5")
        @Expose
        private var strMeasure5: String? = null
        @SerializedName("strMeasure6")
        @Expose
        private var strMeasure6: String? = null
        @SerializedName("strMeasure7")
        @Expose
        private var strMeasure7: String? = null
        @SerializedName("strMeasure8")
        @Expose
        private var strMeasure8: String? = null
        @SerializedName("strMeasure9")
        @Expose
        private var strMeasure9: String? = null
        @SerializedName("strMeasure10")
        @Expose
        private var strMeasure10: String? = null
        @SerializedName("strMeasure11")
        @Expose
        private var strMeasure11: String? = null
        @SerializedName("strMeasure12")
        @Expose
        private var strMeasure12: String? = null
        @SerializedName("strMeasure13")
        @Expose
        private var strMeasure13: String? = null
        @SerializedName("strMeasure14")
        @Expose
        private var strMeasure14: String? = null
        @SerializedName("strMeasure15")
        @Expose
        private var strMeasure15: String? = null
        @SerializedName("strMeasure16")
        @Expose
        private var strMeasure16: String? = null
        @SerializedName("strMeasure17")
        @Expose
        private var strMeasure17: String? = null
        @SerializedName("strMeasure18")
        @Expose
        private var strMeasure18: String? = null
        @SerializedName("strMeasure19")
        @Expose
        private var strMeasure19: String? = null
        @SerializedName("strMeasure20")
        @Expose
        private var strMeasure20: String? = null
        @SerializedName("strSource")
        @Expose
        private var strSource: String? = null
        @SerializedName("dateModified")
        @Expose
        private var dateModified: Any? = null

        fun getIdMeal(): String? {
            return idMeal
        }

        fun setIdMeal(idMeal: String) {
            this.idMeal = idMeal
        }

        fun getStrMeal(): String? {
            return strMeal
        }

        fun setStrMeal(strMeal: String) {
            this.strMeal = strMeal
        }

        fun getStrDrinkAlternate(): Any? {
            return strDrinkAlternate
        }

        fun setStrDrinkAlternate(strDrinkAlternate: Any) {
            this.strDrinkAlternate = strDrinkAlternate
        }

        fun getStrCategory(): String? {
            return strCategory
        }

        fun setStrCategory(strCategory: String) {
            this.strCategory = strCategory
        }

        fun getStrArea(): String? {
            return strArea
        }

        fun setStrArea(strArea: String) {
            this.strArea = strArea
        }

        fun getStrInstructions(): String? {
            return strInstructions
        }

        fun setStrInstructions(strInstructions: String) {
            this.strInstructions = strInstructions
        }

        fun getStrMealThumb(): String? {
            return strMealThumb
        }

        fun setStrMealThumb(strMealThumb: String) {
            this.strMealThumb = strMealThumb
        }

        fun getStrTags(): String? {
            return strTags
        }

        fun setStrTags(strTags: String) {
            this.strTags = strTags
        }

        fun getStrYoutube(): String? {
            return strYoutube
        }

        fun setStrYoutube(strYoutube: String) {
            this.strYoutube = strYoutube
        }

        fun getStrIngredient1(): String? {
            return strIngredient1
        }

        fun setStrIngredient1(strIngredient1: String) {
            this.strIngredient1 = strIngredient1
        }

        fun getStrIngredient2(): String? {
            return strIngredient2
        }

        fun setStrIngredient2(strIngredient2: String) {
            this.strIngredient2 = strIngredient2
        }

        fun getStrIngredient3(): String? {
            return strIngredient3
        }

        fun setStrIngredient3(strIngredient3: String) {
            this.strIngredient3 = strIngredient3
        }

        fun getStrIngredient4(): String? {
            return strIngredient4
        }

        fun setStrIngredient4(strIngredient4: String) {
            this.strIngredient4 = strIngredient4
        }

        fun getStrIngredient5(): String? {
            return strIngredient5
        }

        fun setStrIngredient5(strIngredient5: String) {
            this.strIngredient5 = strIngredient5
        }

        fun getStrIngredient6(): String? {
            return strIngredient6
        }

        fun setStrIngredient6(strIngredient6: String) {
            this.strIngredient6 = strIngredient6
        }

        fun getStrIngredient7(): String? {
            return strIngredient7
        }

        fun setStrIngredient7(strIngredient7: String) {
            this.strIngredient7 = strIngredient7
        }

        fun getStrIngredient8(): String? {
            return strIngredient8
        }

        fun setStrIngredient8(strIngredient8: String) {
            this.strIngredient8 = strIngredient8
        }

        fun getStrIngredient9(): String? {
            return strIngredient9
        }

        fun setStrIngredient9(strIngredient9: String) {
            this.strIngredient9 = strIngredient9
        }

        fun getStrIngredient10(): String? {
            return strIngredient10
        }

        fun setStrIngredient10(strIngredient10: String) {
            this.strIngredient10 = strIngredient10
        }

        fun getStrIngredient11(): String? {
            return strIngredient11
        }

        fun setStrIngredient11(strIngredient11: String) {
            this.strIngredient11 = strIngredient11
        }

        fun getStrIngredient12(): String? {
            return strIngredient12
        }

        fun setStrIngredient12(strIngredient12: String) {
            this.strIngredient12 = strIngredient12
        }

        fun getStrIngredient13(): String? {
            return strIngredient13
        }

        fun setStrIngredient13(strIngredient13: String) {
            this.strIngredient13 = strIngredient13
        }

        fun getStrIngredient14(): String? {
            return strIngredient14
        }

        fun setStrIngredient14(strIngredient14: String) {
            this.strIngredient14 = strIngredient14
        }

        fun getStrIngredient15(): String? {
            return strIngredient15
        }

        fun setStrIngredient15(strIngredient15: String) {
            this.strIngredient15 = strIngredient15
        }

        fun getStrIngredient16(): String? {
            return strIngredient16
        }

        fun setStrIngredient16(strIngredient16: String) {
            this.strIngredient16 = strIngredient16
        }

        fun getStrIngredient17(): String? {
            return strIngredient17
        }

        fun setStrIngredient17(strIngredient17: String) {
            this.strIngredient17 = strIngredient17
        }

        fun getStrIngredient18(): String? {
            return strIngredient18
        }

        fun setStrIngredient18(strIngredient18: String) {
            this.strIngredient18 = strIngredient18
        }

        fun getStrIngredient19(): String? {
            return strIngredient19
        }

        fun setStrIngredient19(strIngredient19: String) {
            this.strIngredient19 = strIngredient19
        }

        fun getStrIngredient20(): String? {
            return strIngredient20
        }

        fun setStrIngredient20(strIngredient20: String) {
            this.strIngredient20 = strIngredient20
        }

        fun getStrMeasure1(): String? {
            return strMeasure1
        }

        fun setStrMeasure1(strMeasure1: String) {
            this.strMeasure1 = strMeasure1
        }

        fun getStrMeasure2(): String? {
            return strMeasure2
        }

        fun setStrMeasure2(strMeasure2: String) {
            this.strMeasure2 = strMeasure2
        }

        fun getStrMeasure3(): String? {
            return strMeasure3
        }

        fun setStrMeasure3(strMeasure3: String) {
            this.strMeasure3 = strMeasure3
        }

        fun getStrMeasure4(): String? {
            return strMeasure4
        }

        fun setStrMeasure4(strMeasure4: String) {
            this.strMeasure4 = strMeasure4
        }

        fun getStrMeasure5(): String? {
            return strMeasure5
        }

        fun setStrMeasure5(strMeasure5: String) {
            this.strMeasure5 = strMeasure5
        }

        fun getStrMeasure6(): String? {
            return strMeasure6
        }

        fun setStrMeasure6(strMeasure6: String) {
            this.strMeasure6 = strMeasure6
        }

        fun getStrMeasure7(): String? {
            return strMeasure7
        }

        fun setStrMeasure7(strMeasure7: String) {
            this.strMeasure7 = strMeasure7
        }

        fun getStrMeasure8(): String? {
            return strMeasure8
        }

        fun setStrMeasure8(strMeasure8: String) {
            this.strMeasure8 = strMeasure8
        }

        fun getStrMeasure9(): String? {
            return strMeasure9
        }

        fun setStrMeasure9(strMeasure9: String) {
            this.strMeasure9 = strMeasure9
        }

        fun getStrMeasure10(): String? {
            return strMeasure10
        }

        fun setStrMeasure10(strMeasure10: String) {
            this.strMeasure10 = strMeasure10
        }

        fun getStrMeasure11(): String? {
            return strMeasure11
        }

        fun setStrMeasure11(strMeasure11: String) {
            this.strMeasure11 = strMeasure11
        }

        fun getStrMeasure12(): String? {
            return strMeasure12
        }

        fun setStrMeasure12(strMeasure12: String) {
            this.strMeasure12 = strMeasure12
        }

        fun getStrMeasure13(): String? {
            return strMeasure13
        }

        fun setStrMeasure13(strMeasure13: String) {
            this.strMeasure13 = strMeasure13
        }

        fun getStrMeasure14(): String? {
            return strMeasure14
        }

        fun setStrMeasure14(strMeasure14: String) {
            this.strMeasure14 = strMeasure14
        }

        fun getStrMeasure15(): String? {
            return strMeasure15
        }

        fun setStrMeasure15(strMeasure15: String) {
            this.strMeasure15 = strMeasure15
        }

        fun getStrMeasure16(): String? {
            return strMeasure16
        }

        fun setStrMeasure16(strMeasure16: String) {
            this.strMeasure16 = strMeasure16
        }

        fun getStrMeasure17(): String? {
            return strMeasure17
        }

        fun setStrMeasure17(strMeasure17: String) {
            this.strMeasure17 = strMeasure17
        }

        fun getStrMeasure18(): String? {
            return strMeasure18
        }

        fun setStrMeasure18(strMeasure18: String) {
            this.strMeasure18 = strMeasure18
        }

        fun getStrMeasure19(): String? {
            return strMeasure19
        }

        fun setStrMeasure19(strMeasure19: String) {
            this.strMeasure19 = strMeasure19
        }

        fun getStrMeasure20(): String? {
            return strMeasure20
        }

        fun setStrMeasure20(strMeasure20: String) {
            this.strMeasure20 = strMeasure20
        }

        fun getStrSource(): String? {
            return strSource
        }

        fun setStrSource(strSource: String) {
            this.strSource = strSource
        }

        fun getDateModified(): Any? {
            return dateModified
        }

        fun setDateModified(dateModified: Any) {
            this.dateModified = dateModified
        }
    }
}