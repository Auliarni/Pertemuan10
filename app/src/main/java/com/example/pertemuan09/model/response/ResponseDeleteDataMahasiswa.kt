package com.example.pertemuan09.model.response


import com.google.gson.annotations.SerializedName

data class ResponseDeleteDataMahasiswa(
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: String
)