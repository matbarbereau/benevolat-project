package com.mat.benevolat.resource

import java.util.*

data class MembreResource(val id: UUID = UUID.randomUUID(), val matricule: String, val prenom: String, val nom: String) {
}
