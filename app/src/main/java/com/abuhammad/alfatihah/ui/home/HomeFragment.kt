package com.abuhammad.alfatihah.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abuhammad.alfatihah.R
import com.abuhammad.alfatihah.adapter.MenuAdapter
import com.abuhammad.alfatihah.databinding.FragmentHomeBinding
import com.abuhammad.alfatihah.model.MenuItem
import com.abuhammad.alfatihah.ui.home.detailhome.CaraFragment
import com.abuhammad.alfatihah.ui.home.detailhome.FikihFragment
import com.abuhammad.alfatihah.ui.home.detailhome.JenisFragment
import com.abuhammad.alfatihah.ui.home.detailhome.KeutamaanFragment
import com.abuhammad.alfatihah.ui.home.detailhome.LahnFragment
import com.abuhammad.alfatihah.ui.quran.QuranFragmentDirections

@Suppress("IMPLICIT_CAST_TO_ANY")
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuItems = listOf(
            MenuItem(
                id = 1,
                tittle = "Keutamaan Al-Fatihah",
                desc = "Pahami keutamaan agar semangat belajar",
                image = R.drawable.keutamaan
            ),
            MenuItem(
                id = 2,
                tittle = "Cara Membaca Al-Fatihah",
                desc = "Panduan membaca Al-Fatihah per Ayat",
                image = R.drawable.caramembaca
            ),
            MenuItem(
                id = 3,
                tittle = "LAHN dan Macamnya",
                desc = "Ketahuilah jenis LAHN agar tidak salah baca",
                image = R.drawable.lahndanmacamnya
            ),
            MenuItem(
                id = 4,
                tittle = "LAHN Khofiy dan LAHN Jaliy",
                desc = "Perincian LAHN pada Al-Fatihah",
                image = R.drawable.lahnkhofiydanjaliy
            ),
            MenuItem(
                id = 5,
                tittle = "Fikih LAHN Al-Fatihah",
                desc = "Penjelasan hukum dan hal-hal lainnya",
                image = R.drawable.fikihlahn
            ),
            MenuItem(
                id = 6,
                tittle = "Setor Al-Fatihah",
                desc = "Kirimkan rekaman Al-Fatihah kamu disini",
                image = R.drawable.setoralfatihah
            )

        )

        val tittleKeutamaan = HomeFragmentDirections.actionNavigationHomeToKeutamaanFragment("Keutamaan Al-Fatihah")
        val tittleCara = HomeFragmentDirections.actionNavigationHomeToCaraFragment("Cara Membaca Al-Fatihah")
        val tittleLahn = HomeFragmentDirections.actionNavigationHomeToLahnFragment("LAHN dan Macamnya")
        val tittleJenis = HomeFragmentDirections.actionNavigationHomeToJenisFragment("LAHN Khofiy dan LAHN Jaliy")
        val tittleFikih = HomeFragmentDirections.actionNavigationHomeToFikihFragment("Fikih LAHN Al-Fatihah")

        // Setup RecyclerView
        binding.rvMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMenu.adapter = MenuAdapter(menuItems) { menuItem ->
            // Tindakan saat item diklik
            // Misalnya, navigasi ke detail
            when(menuItem.id){
                1 -> findNavController().navigate(tittleKeutamaan)
                2 -> findNavController().navigate(tittleCara)
                3 -> findNavController().navigate(tittleLahn)
                4 -> findNavController().navigate(tittleJenis)
                5 -> findNavController().navigate(tittleFikih)
                6 -> {
                    // Nomor WhatsApp
                    val phoneNumber = "6281775205889" // Ganti dengan nomor WhatsApp Anda
                    // Pesan
                    val message = "Assalamualaykum, saya ingin setorkan alfatihah saya"

                    // Membuat URI WhatsApp
                    val uri = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber&text=${Uri.encode(message)}")

                    // Intent untuk membuka WhatsApp
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
                else -> {
                    Log.i("searchFragment", "Fragment null")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}