package com.example.galeriadeimagenes

import androidx.annotation.DrawableRes

data class Galeria(

    var titulo: String,
    @DrawableRes var imagen: Int

)
