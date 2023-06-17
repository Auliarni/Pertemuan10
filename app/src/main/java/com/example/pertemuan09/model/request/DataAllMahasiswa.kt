package com.example.pertemuan09.model.request


import com.google.gson.annotations.SerializedName

data class DataAllMahasiswa(
    @SerializedName("NIM")
    val nIM: String,
    @SerializedName("Nama")
    val nama: String,
    @SerializedName("Telepon")
    val telepon: String
)