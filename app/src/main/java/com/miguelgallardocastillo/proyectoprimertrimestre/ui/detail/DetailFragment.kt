package com.miguelgallardocastillo.proyectoprimertrimestre.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.fragment.app.viewModels
import com.miguelgallardocastillo.proyectoprimertrimestre.R
import com.miguelgallardocastillo.proyectoprimertrimestre.databinding.FragmentDetailBinding
import com.miguelgallardocastillo.proyectoprimertrimestre.model.Receta
import com.miguelgallardocastillo.proyectoprimertrimestre.ui.main.glide



class DetailFragment : Fragment(R.layout.fragment_detail) {

    private  val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(arguments?.getParcelable<Receta>(EXTRA_RECETA)!!)
    }

    companion object {
        //El valor de esta constante es estática.
        const val EXTRA_RECETA = "DetailFragment:Receta"
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)

        viewModel.receta.observe(viewLifecycleOwner){ receta ->
            (requireActivity() as AppCompatActivity).supportActionBar?.title = receta.label

            binding.dTituloReceta.text = receta.label
            binding.dImagenReceta.glide(receta.image)
            binding.tiempoPreparacion.text = "Número de calorías: " + receta.calories
            binding.numComensales.text = "Tipo de receta: " + receta.mealType

            binding.buttonEnlaceReceta.setOnClickListener{

                val uri = Uri.parse(receta.urlReceta)
                val intent  = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }

    }


}//Fin del DetailFragment.