package com.example.tourism.model


import com.google.gson.annotations.SerializedName

data class Places(
    @SerializedName("place")
    val place: List<String>
)