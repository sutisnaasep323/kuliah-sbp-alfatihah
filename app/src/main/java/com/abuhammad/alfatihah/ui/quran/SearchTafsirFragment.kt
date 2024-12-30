package com.abuhammad.alfatihah.ui.quran

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.adapter.SearchResultsAdapter
import com.abuhammad.alfatihah.api.ApiConfig
import com.abuhammad.alfatihah.databinding.FragmentCaraBinding
import com.abuhammad.alfatihah.databinding.FragmentSearchTafsirBinding
import com.abuhammad.alfatihah.model.QuranDetailResponse
import com.abuhammad.alfatihah.model.SearchResult
import com.abuhammad.alfatihah.ui.detail.DetailQuranFragmentArgs
import com.asep.ruhkehidupan.api.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class SearchTafsirFragment : Fragment() {
    private var _binding: FragmentSearchTafsirBinding? = null
    private val binding get() = _binding!!
    private lateinit var apiService: ApiService
    private lateinit var searchResultsAdapter: SearchResultsAdapter
    private val searchResults = mutableListOf<SearchResult>()
    private val args: SearchTafsirFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchTafsirBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        binding.rvTafsir.layoutManager = LinearLayoutManager(requireContext())

        apiService = ApiConfig.getApiService() // Initialize ApiService
        setupRecyclerView(view)

        val query = args.EXTRANAMESEARCH
        if (query.isNotEmpty()) {
            searchTafsir(query)
        }

    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_tafsir)
        searchResultsAdapter = SearchResultsAdapter(searchResults)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = searchResultsAdapter
    }

    private fun searchTafsir(query: String) {
        lifecycleScope.launch {
            showLoading()
            searchResults.clear()

            val results = (1..114).map { surahId ->
                async {
                    try {
                        val response = apiService.getDetailSurah(surahId).awaitResponse()
                        if (response.isSuccessful) {
                            val ayahs = response.body()?.data?.ayahs
                            ayahs?.filter { it.tafsir.id.contains(query, ignoreCase = true) }
                                ?.map {
                                    SearchResult(
                                        surahName = response.body()?.data?.asma?.id?.jsonMemberShort
                                            ?: "Unknown Surah",
                                        ayahNumber = it.number.insurah,
                                        tafsir = it.tafsir.id
                                    )
                                } ?: emptyList()
                        } else emptyList()
                    } catch (e: Exception) {
                        emptyList<SearchResult>()
                    }
                }
            }.awaitAll().flatten()

            hideLoading()
            if (results.isEmpty()) {
                showNotFound()
            } else {
                searchResults.addAll(results.take(5))
                searchResultsAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun showLoading() {
        binding.lottieAnimationView.setAnimation("searchtafsir.json")
        binding.lottieAnimationView.visibility = View.VISIBLE
        binding.lottieAnimationView.playAnimation()

        binding.statusText.text = "Sedang Mencari Tafsir.."
        binding.statusText.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.lottieAnimationView.cancelAnimation()
        binding.lottieAnimationView.visibility = View.GONE
        binding.statusText.visibility = View.GONE
    }

    private fun showNotFound() {
        binding.lottieAnimationView.setAnimation("notfound.json")
        binding.lottieAnimationView.visibility = View.VISIBLE
        binding.lottieAnimationView.playAnimation()

        binding.statusText.text = "Tafsir tidak ditemukan!"
        binding.statusText.visibility = View.VISIBLE
    }
}