package com.miguelgallardocastillo.proyectoprimertrimestre.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Receta (val label: String, val image:String, val calories:String, val mealType:String, val urlReceta:String?)
    :Parcelable{
}