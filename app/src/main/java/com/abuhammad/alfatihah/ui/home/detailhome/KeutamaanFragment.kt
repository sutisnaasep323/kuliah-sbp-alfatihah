package com.abuhammad.alfatihah.ui.home.detailhome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.adapter.ContentAdapter
import com.abuhammad.alfatihah.databinding.FragmentKeutamaanBinding
import com.abuhammad.alfatihah.model.MenuItem
import com.abuhammad.alfatihah.ui.quran.QuranFragmentDirections

class KeutamaanFragment : Fragment() {
    private val args: KeutamaanFragmentArgs by navArgs()
    private var _binding: FragmentKeutamaanBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeutamaanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

    }
    private fun setupUI() {
        val nameContent = args.tittleHomeKeutamaan

        binding.tittleToolbar.text = nameContent
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        val contentItems = listOf(
            MenuItem(
                id = 1,
                tittle = getString(R.string.content_menu_keutamaan_title_rukun),
                desc = getString(R.string.content_menu_keutamaan_title_rukun_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 2,
                tittle = getString(R.string.content_menu_keutamaan_title_suratmulia),
                desc = getString(R.string.content_menu_keutamaan_title_suratmulia_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 3,
                tittle = getString(R.string.content_menu_keutamaan_title_sabulmatsani),
                desc = getString(R.string.content_menu_keutamaan_title_sabulmatsani_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 4,
                tittle = getString(R.string.content_menu_keutamaan_title_ummulquran),
                desc = getString(R.string.content_menu_keutamaan_title_ummulquran_desc),
                image = R.drawable.readbook_4
            )
        )

        binding.rvContentCara.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContentCara.adapter = ContentAdapter(contentItems) { contentItem ->
            val action = KeutamaanFragmentDirections.actionKeutamaanFragmentToDetailContentFragment(
                contentId = contentItem.id,
                contentTitle = contentItem.tittle!!,
                contentDesc = contentItem.desc!!
            )
            findNavController().navigate(action)
        }
    }
}