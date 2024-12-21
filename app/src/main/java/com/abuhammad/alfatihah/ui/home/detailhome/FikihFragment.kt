package com.abuhammad.alfatihah.ui.home.detailhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.adapter.ContentAdapter
import com.abuhammad.alfatihah.databinding.FragmentCaraBinding
import com.abuhammad.alfatihah.databinding.FragmentFikihBinding
import com.abuhammad.alfatihah.model.MenuItem


class FikihFragment : Fragment() {
    private val args: FikihFragmentArgs by navArgs()
    private var _binding: FragmentFikihBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFikihBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }
    private fun setupUI() {
        val nameContent = args.tittleHomeFikih

        binding.tittleToolbar.text = nameContent
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        val contentItems = listOf(
            MenuItem(
                id = 1,
                tittle = getString(R.string.content_menu_fikih_lahnmembatalkan_title),
                desc = getString(R.string.content_menu_fikih_lahnmembatalkan_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 2,
                tittle = getString(R.string.content_menu_fikih_lahntidakmerusak_title),
                desc = getString(R.string.content_menu_fikih_lahntidakmerusak_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 3,
                tittle = getString(R.string.content_menu_fikih_lahnshalatsendiri_title),
                desc = getString(R.string.content_menu_fikih_lahnshalatsendiri_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 4,
                tittle = getString(R.string.content_menu_fikih_Lahnberimamdenganlahn_title),
                desc = getString(R.string.content_menu_fikih_Lahnberimamdenganlahn_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 5,
                tittle = getString(R.string.content_menu_fikih_qoriberimamdenganummy_title),
                desc = getString(R.string.content_menu_fikih_qoriberimamdenganummy_desc),
                image = R.drawable.readbook_5
            ),
            MenuItem(
                id = 6,
                tittle = getString(R.string.content_menu_fikih_sikapmakmum_title),
                desc = getString(R.string.content_menu_fikih_sikapmakmum_desc),
                image = R.drawable.readbook_6
            ),
            MenuItem(
                id = 7,
                tittle = getString(R.string.content_menu_fikih_sikapimam_title),
                desc = getString(R.string.content_menu_fikih_sikapimam_desc),
                image = R.drawable.readbook_7
            )
        )

        binding.rvContentCara.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContentCara.adapter = ContentAdapter(contentItems) { contentItem ->
            val action = FikihFragmentDirections.actionFikihFragmentToDetailContentFragment(
                contentId = contentItem.id,
                contentTitle = contentItem.tittle!!,
                contentDesc = contentItem.desc!!
            )
            findNavController().navigate(action)
        }
    }
}