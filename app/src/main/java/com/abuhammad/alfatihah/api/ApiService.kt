package com.asep.ruhkehidupan.api

import com.abuhammad.alfatihah.model.QuranDetailResponse
import com.abuhammad.alfatihah.model.QuranResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("quran")
    fun getListSurah(): Call<QuranResponse>

    @GET("quran/{id}")
    fun getDetailSurah(
        @Path("id") id: Int
    ): Call<QuranDetailResponse>
}