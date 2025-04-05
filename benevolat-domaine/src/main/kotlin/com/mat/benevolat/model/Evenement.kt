package com.mat.benevolat.model

import java.util.*

data class Evenement (val idEvenement: String, val dateDebut: Date, val dateFin: Date, val lieu: String,
                      val nombreBenevolesNecessaires: Int, val listeDesBenevoles: List<Benevole>)
