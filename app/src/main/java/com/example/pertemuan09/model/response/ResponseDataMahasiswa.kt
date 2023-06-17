package com.example.pertemuan09.model.response


import com.example.pertemuan09.model.request.DataAllMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDataMahasiswa(
    @SerializedName("data")
    val data: List<DataAllMahasiswa>,
    @SerializedName("status")
    val status: String
)