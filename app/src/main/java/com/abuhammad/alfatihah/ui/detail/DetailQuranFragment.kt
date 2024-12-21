package com.abuhammad.alfatihah.ui.detail

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.abuhammad.alfatihah.adapter.DetailSurahAdapter
import com.abuhammad.alfatihah.databinding.FragmentDetailQuranBinding

class DetailQuranFragment : Fragment() {

    private lateinit var mQuranDetailViewModel: DetailQuranViewModel
    private lateinit var detailSurahAdapter: DetailSurahAdapter
    private val args: DetailQuranFragmentArgs by navArgs()

    private var _binding: FragmentDetailQuranBinding? = null
    private val binding get() = _binding!!
    private var idSurah: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupViewModel()
        setupObservers()

    }

    private fun setupUI() {
        val nameSurah = args.EXTRANAMESURAH
        idSurah = args.EXTRAIDSURAH

        binding.tittleToolbar.text = nameSurah
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        detailSurahAdapter = DetailSurahAdapter()
        binding.rvDetailSurah.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = detailSurahAdapter
        }
    }

    private fun setupViewModel() {
        mQuranDetailViewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailQuranViewModel::class.java)
        id?.let { mQuranDetailViewModel.setListSurah(idSurah) }
    }

    private fun setupObservers() {
        mQuranDetailViewModel.listDetailSurah.observe(viewLifecycleOwner) { data ->
            if (data.isNotEmpty()) {
                detailSurahAdapter.setData(data)
            } else {
                Toast.makeText(requireActivity(), "Data Tidak Ditemukan!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        mQuranDetailViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            showLoading(isLoading)
        }

    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}