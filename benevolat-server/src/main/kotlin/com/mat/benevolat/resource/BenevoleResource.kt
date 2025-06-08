package com.mat.benevolat.resource

import java.util.*

data class BenevoleResource(val id : UUID = UUID.randomUUID(), val prenom: String, val nom: String) {
}
