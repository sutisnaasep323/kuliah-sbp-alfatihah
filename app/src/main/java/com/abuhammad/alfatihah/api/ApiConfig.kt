package com.abuhammad.alfatihah.api

//import com.abuhammad.alfatihah.BuildConfig
import com.asep.ruhkehidupan.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://quran-endpoint.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getApiService(): ApiService {
            return getRetrofit().create(ApiService::class.java)
        }
}