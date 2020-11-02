package com.petcare.hilt_retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlbumItem(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("userId")
    val userId: Int
)