package com.abuhammad.alfatihah.ui.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.adapter.SurahAdapter
import com.abuhammad.alfatihah.databinding.FragmentQuranBinding
import com.abuhammad.alfatihah.model.Data
import com.abuhammad.alfatihah.network.NetworkUtils
import com.abuhammad.alfatihah.ui.detail.DetailQuranFragment

class QuranFragment : Fragment() {
    private lateinit var mQuranViewModel: QuranViewModel
    private var _binding: FragmentQuranBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (NetworkUtils.isInternetAvailable(requireContext())) {
            // Inisialisasi ViewModel
            setupViewModel()

            // Konfigurasi tampilan UI
            setupUI()

            // Observasi perubahan data
            setupObservers()
        } else {
            // Tampilkan UI saat tidak ada koneksi internet
            showNoInternetUI()
        }
    }

    private fun setupViewModel() {
        mQuranViewModel =
            ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory()).get(
                QuranViewModel::class.java
            )
    }

    private fun setupUI() {
        binding.rvSurah.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupObservers() {
        mQuranViewModel.listSurah.observe(viewLifecycleOwner) { data ->
            setListSurah(data)
        }

        mQuranViewModel.isLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }
    }

    private fun showNoInternetUI() {
        binding.rvSurah.visibility = View.GONE
        binding.errorLayout.visibility = View.VISIBLE
        binding.btnRefresh.setOnClickListener {
            quranRefresh()
        }
        showLoading(false)
    }

    private fun quranRefresh() {
        val navController = findNavController()

        // Hapus fragment yang ada dari back stack dan muat ulang
        navController.popBackStack(R.id.navigation_quran, true)
        navController.navigate(R.id.navigation_quran)
    }

    private fun setListSurah(data: List<Data>?) {
        val listSurahAdapter = data?.let { SurahAdapter(it) }
        binding.rvSurah.apply {
            setHasFixedSize(true)
            listSurahAdapter?.notifyDataSetChanged()
            adapter = listSurahAdapter
        }

        listSurahAdapter?.setOnItemClickCallback(object : SurahAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Data) {
                onDetailClick(data)
            }
        })
    }

    private fun onDetailClick(data: Data) {
        val action = QuranFragmentDirections.actionNavigationQuranToDetailQuranFragment(data.asma.id.jsonMemberLong, data.number)
        findNavController().navigate(action)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}