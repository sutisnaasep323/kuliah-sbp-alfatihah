package com.abuhammad.alfatihah.ui.quran

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abuhammad.alfatihah.api.ApiConfig
import com.abuhammad.alfatihah.model.Data
import com.abuhammad.alfatihah.model.QuranResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranViewModel : ViewModel() {
    private val _listSurah = MutableLiveData<List<Data>>()
    val listSurah: LiveData<List<Data>> = _listSurah

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        fetchListSurah()
    }

    private fun fetchListSurah() {
        _isLoading.value = true
        val apiService = ApiConfig.getApiService()
        val callback = object : Callback<QuranResponse> {
            override fun onResponse(call: Call<QuranResponse>, response: Response<QuranResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listSurah.value = response.body()?.data
                } else {
                    Log.e("failure", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<QuranResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("failure", t.toString())
            }
        }
        apiService.getListSurah().enqueue(callback)
    }
}