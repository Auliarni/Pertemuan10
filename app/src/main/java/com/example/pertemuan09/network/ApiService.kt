package com.example.pertemuan09.network

import com.example.pertemuan09.model.request.Mahasiswa
import com.example.pertemuan09.model.response.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("datamahasiswa/")
    fun getDataMahasiswa() : Call<ResponseDataMahasiswa>

    @GET("datamahasiswa/{nim}")
    fun getDetailMahasiswa(@Path("nim") nim : String) :
            Call<ResponseDetailDataMahasiswa>

    @POST("datamahasiswa/")
    fun addDataMahasiswa(@Body data : Mahasiswa) :
            Call<ResponseAddDataMahasiswa>

    @DELETE("datamahasiswa/{nim}")
    fun deleteDataMahasiswa(@Path("nim") nim : String) :
            Call<ResponseDeleteDataMahasiswa>

    @POST("datamahasiswa/{nim}")
    fun updateDataMahasiswa(@Path("nim") nim: String, @Body data: Mahasiswa) :
            Call<ResponseDataUpdateMahasiswa>
}