package com.pavesid.foodsappkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Categories: Serializable {
    @SerializedName("categories")
    @Expose
    private var categories: List<Category>? = null

    fun getCategories(): List<Category>? {
        return categories
    }

    fun setCategories(categories: List<Category>) {
        this.categories = categories
    }

    inner class Category: Serializable {
        @SerializedName("idCategory")
        @Expose
        private var idCategory: String? = null
        @SerializedName("strCategory")
        @Expose
        private var strCategory: String? = null
        @SerializedName("strCategoryThumb")
        @Expose
        private var strCategoryThumb: String? = null
        @SerializedName("strCategoryDescription")
        @Expose
        private var strCategoryDescription: String? = null

        fun getIdCategory(): String? {
            return idCategory
        }

        fun setIdCategory(idCategory: String) {
            this.idCategory = idCategory
        }

        fun getStrCategory(): String? {
            return strCategory
        }

        fun setStrCategory(strCategory: String) {
            this.strCategory = strCategory
        }

        fun getStrCategoryThumb(): String? {
            return strCategoryThumb
        }

        fun setStrCategoryThumb(strCategoryThumb: String) {
            this.strCategoryThumb = strCategoryThumb
        }

        fun getStrCategoryDescription(): String? {
            return strCategoryDescription
        }

        fun setStrCategoryDescription(strCategoryDescription: String) {
            this.strCategoryDescription = strCategoryDescription
        }
    }
}