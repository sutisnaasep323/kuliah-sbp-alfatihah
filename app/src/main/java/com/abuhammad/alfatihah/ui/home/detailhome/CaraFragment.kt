package com.abuhammad.alfatihah.ui.home.detailhome

import android.os.Bundle
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
import com.abuhammad.alfatihah.databinding.FragmentCaraBinding
import com.abuhammad.alfatihah.databinding.FragmentDetailQuranBinding
import com.abuhammad.alfatihah.model.MenuItem
import com.abuhammad.alfatihah.ui.detail.DetailQuranFragmentArgs


class CaraFragment : Fragment() {
    private val args: CaraFragmentArgs by navArgs()
    private var _binding: FragmentCaraBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCaraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }
    private fun setupUI() {
        val nameContent = args.tittleHomeCara

        binding.tittleToolbar.text = nameContent
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        val contentItems = listOf(
            MenuItem(
                id = 1,
                tittle = getString(R.string.content_menu_cara_alfatihah_1),
                desc = getString(R.string.content_menu_cara_alfatihah_1_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 2,
                tittle = getString(R.string.content_menu_cara_alfatihah_2),
                desc = getString(R.string.content_menu_cara_alfatihah_2_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 3,
                tittle = getString(R.string.content_menu_cara_alfatihah_3),
                desc = getString(R.string.content_menu_cara_alfatihah_3_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 4,
                tittle = getString(R.string.content_menu_cara_alfatihah_4),
                desc = getString(R.string.content_menu_cara_alfatihah_4_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 5,
                tittle = getString(R.string.content_menu_cara_alfatihah_5),
                desc = getString(R.string.content_menu_cara_alfatihah_5_desc),
                image = R.drawable.readbook_5
            ),
            MenuItem(
                id = 6,
                tittle = getString(R.string.content_menu_cara_alfatihah_6),
                desc = getString(R.string.content_menu_cara_alfatihah_6_desc),
                image = R.drawable.readbook_6
            ),
            MenuItem(
                id = 7,
                tittle = getString(R.string.content_menu_cara_alfatihah_7),
                desc = getString(R.string.content_menu_cara_alfatihah_7_desc),
                image = R.drawable.readbook_7
            )
        )

        binding.rvContentCara.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContentCara.adapter = ContentAdapter(contentItems) { contentItem ->
            val action = CaraFragmentDirections.actionCaraFragmentToDetailContentFragment(
                contentId = contentItem.id,
                contentTitle = contentItem.tittle!!,
                contentDesc = contentItem.desc!!
            )
            findNavController().navigate(action)
        }
    }
}