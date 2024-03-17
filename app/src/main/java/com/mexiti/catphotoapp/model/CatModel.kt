package com.mexiti.catphotoapp.model

import kotlinx.serialization.Serializable
@Serializable
data class CatModel(
    val id:String,
    val url:String,
    val width: Int,
    val height: Int,
)

