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
import com.abuhammad.alfatihah.databinding.FragmentJenisBinding
import com.abuhammad.alfatihah.model.MenuItem
import com.abuhammad.alfatihah.ui.home.HomeFragmentDirections


class JenisFragment : Fragment() {
    private val args: JenisFragmentArgs by navArgs()
    private var _binding: FragmentJenisBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJenisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }
    private fun setupUI() {
        val nameContent = args.tittleHomeJenis

        binding.tittleToolbar.text = nameContent
        binding.backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        val contentItems = listOf(
            MenuItem(
                id = 1,
                tittle = getString(R.string.content_menu_audzu_title),
                desc = getString(R.string.content_menu_audzu_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 2,
                tittle = getString(R.string.content_menu_bismi_title),
                desc = getString(R.string.content_menu_billahi_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 3,
                tittle = getString(R.string.content_menu_minasy_title),
                desc = getString(R.string.content_menu_minasy_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 4,
                tittle = getString(R.string.content_menu_rajim_title),
                desc = getString(R.string.content_menu_rajim_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 5,
                tittle = getString(R.string.content_menu_bismi_title),
                desc = getString(R.string.content_menu_bismi_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 6,
                tittle = getString(R.string.content_menu_lillahi_title),
                desc = getString(R.string.content_menu_lillahi_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 7,
                tittle = getString(R.string.content_menu_arrahmani_title),
                desc = getString(R.string.content_menu_arrahmani_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 8,
                tittle = getString(R.string.content_menu_rahimi_title),
                desc = getString(R.string.content_menu_rahimi_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 9,
                tittle = getString(R.string.content_menu_alhamdu_title),
                desc = getString(R.string.content_menu_alhamdu_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 10,
                tittle = getString(R.string.content_menu_rabi_title),
                desc = getString(R.string.content_menu_rabi_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 11,
                tittle = getString(R.string.content_menu_alamin_title),
                desc = getString(R.string.content_menu_alamin_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 12,
                tittle = getString(R.string.content_menu_maliki_title),
                desc = getString(R.string.content_menu_maliki_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 13,
                tittle = getString(R.string.content_menu_yaumi_title),
                desc = getString(R.string.content_menu_yaumi_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 14,
                tittle = getString(R.string.content_menu_addin_title),
                desc = getString(R.string.content_menu_addin_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 15,
                tittle = getString(R.string.content_menu_iyyaka_title),
                desc = getString(R.string.content_menu_iyyaka_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 16,
                tittle = getString(R.string.content_menu_nabudu_title),
                desc = getString(R.string.content_menu_nabudu_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 17,
                tittle = getString(R.string.content_menu_nastain_title),
                desc = getString(R.string.content_menu_nastain_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 18,
                tittle = getString(R.string.content_menu_ihdina_title),
                desc = getString(R.string.content_menu_ihdina_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 19,
                tittle = getString(R.string.content_menu_shiroto_title),
                desc = getString(R.string.content_menu_shiroto_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 20,
                tittle = getString(R.string.content_menu_mustaqim_title),
                desc = getString(R.string.content_menu_mustaqim_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 21,
                tittle = getString(R.string.content_menu_alladzina_title),
                desc = getString(R.string.content_menu_alladzina_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 22,
                tittle = getString(R.string.content_menu_anamta_title),
                desc = getString(R.string.content_menu_anamta_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 23,
                tittle = getString(R.string.content_menu_alayhim_title),
                desc = getString(R.string.content_menu_alayhim_desc),
                image = R.drawable.readbook_2
            ),
            MenuItem(
                id = 24,
                tittle = getString(R.string.content_menu_ghairi_title),
                desc = getString(R.string.content_menu_ghairi_desc),
                image = R.drawable.readbook_3
            ),
            MenuItem(
                id = 25,
                tittle = getString(R.string.content_menu_maghdhubi_title),
                desc = getString(R.string.content_menu_maghdhubi_desc),
                image = R.drawable.readbook_4
            ),
            MenuItem(
                id = 26,
                tittle = getString(R.string.content_menu_alayhim_title),
                desc = getString(R.string.content_menu_alayhim_desc),
                image = R.drawable.readbook_1
            ),
            MenuItem(
                id = 27,
                tittle = getString(R.string.content_menu_dhalin_title),
                desc = getString(R.string.content_menu_dhalin_desc),
                image = R.drawable.readbook_1
            )
        )

        binding.rvContent.layoutManager = LinearLayoutManager(requireContext())
        binding.rvContent.adapter = ContentAdapter(contentItems) { contentItem ->
            val action = JenisFragmentDirections.actionJenisFragmentToDetailContentFragment(
                contentId = contentItem.id,
                contentTitle = contentItem.tittle!!,
                contentDesc = contentItem.desc!!
            )
            findNavController().navigate(action)
        }
    }

}