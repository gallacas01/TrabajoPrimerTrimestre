package com.miguelgallardocastillo.proyectoprimertrimestre.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.miguelgallardocastillo.proyectoprimertrimestre.R
import com.miguelgallardocastillo.proyectoprimertrimestre.databinding.FragmentDetailBinding
import com.miguelgallardocastillo.proyectoprimertrimestre.databinding.FragmentFavouritesBinding
import com.miguelgallardocastillo.proyectoprimertrimestre.databinding.FragmentMainBinding
import com.miguelgallardocastillo.proyectoprimertrimestre.model.Receta
import com.miguelgallardocastillo.proyectoprimertrimestre.ui.detail.DetailFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FavouritesFragment : Fragment(R.layout.fragment_favourites) {

    private lateinit var binding : FragmentFavouritesBinding
    private val viewModel : MainViewModel by viewModels()
    private val adapter = RecetaAdapter(){ Receta -> viewModel.navigateTo(Receta) }

    companion object {
        const val EXTRA_RECETA_FAVORITA = "DetailFragment:Receta"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view).apply {
            recyclerviewRecetas.adapter = adapter
        }

        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.app_name)
        getString(R.string.app_name)

        CoroutineScope(Dispatchers.IO).launch {

            binding.textoBienvenida.text = "Recetas favoritas"
            val recetasFavoritas: MutableList<Receta> = DetailFragment().getRecetasFavoritas()
            adapter.listaRecetas = recetasFavoritas
            adapter.notifyDataSetChanged()
        }
    }




}//Fin de la clase.

