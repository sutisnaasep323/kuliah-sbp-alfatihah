package com.abuhammad.alfatihah.ui.home.detailhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.databinding.FragmentDetailContentBinding


class DetailContentFragment : Fragment() {
    private var _binding: FragmentDetailContentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Ambil argumen
        val args: DetailContentFragmentArgs by navArgs()
        val contentId = args.contentId
        val contentTitle = args.contentTitle
        val contentDesc = args.contentDesc

        // Set data ke view
        binding.detailTitle.text = contentTitle
        binding.detailContent.text = contentDesc
        binding.tittleToolbar.text = contentTitle
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}