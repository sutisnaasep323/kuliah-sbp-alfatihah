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
import com.abuhammad.alfatihah.databinding.FragmentLahnBinding
import com.abuhammad.alfatihah.model.MenuItem
import com.abuhammad.alfatihah.ui.home.HomeFragmentDirections


class LahnFragment : Fragment() {
    private val args: LahnFragmentArgs by navArgs()
    private var _binding: FragmentLahnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLahnBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }
    private fun setupUI() {
        val nameContent = args.tittleHomeLahn

        binding.tittleToolbar.text = nameContent
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        val contentItems = listOf(
            MenuItem(
                id = 1,
                tittle = getString(R.string.content_menu_lahn_pengertian_title),
                desc = getString(R.string.content_menu_lahn_pengertian_title_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 2,
                tittle = getString(R.string.content_menu_lahn_macam_title),
                desc = getString(R.string.content_menu_lahn_macam_title_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 3,
                tittle = getString(R.string.content_menu_lahn_jaliy_title),
                desc = getString(R.string.content_menu_lahn_jaliy_title_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 4,
                tittle = getString(R.string.content_menu_lahn_hukum_jaliy_title),
                desc = getString(R.string.content_menu_lahn_hukum_jaliy_title_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 5,
                tittle = getString(R.string.content_menu_lahn_khofy_title),
                desc = getString(R.string.content_menu_lahn_khofy_title_desc),
                image = R.drawable.readbook_5
            ),
            MenuItem(
                id = 6,
                tittle = getString(R.string.content_menu_lahn_bentuk_khofy_title),
                desc = getString(R.string.content_menu_lahn_bentuk_khofy_title_desc),
                image = R.drawable.readbook_6
            )
        )

        binding.rvContent.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContent.adapter = ContentAdapter(contentItems) { contentItem ->
            val action = LahnFragmentDirections.actionLahnFragmentToDetailContentFragment(
                contentId = contentItem.id,
                contentTitle = contentItem.tittle!!,
                contentDesc = contentItem.desc!!
            )
            findNavController().navigate(action)
        }
    }
}