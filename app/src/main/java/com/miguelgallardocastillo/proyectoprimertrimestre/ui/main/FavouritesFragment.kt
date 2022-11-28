package com.miguelgallardocastillo.proyectoprimertrimestre.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelgallardocastillo.proyectoprimertrimestre.R
import com.miguelgallardocastillo.proyectoprimertrimestre.databinding.FragmentDetailBinding
import com.miguelgallardocastillo.proyectoprimertrimestre.databinding.FragmentFavouritesBinding


class FavouritesFragment : Fragment(R.layout.fragment_favourites) {

    private lateinit var binding : FragmentFavouritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {

    }
}