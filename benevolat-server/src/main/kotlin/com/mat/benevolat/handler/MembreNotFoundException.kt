package com.mat.benevolat.handler

import java.util.*

class MembreNotFoundException (message: String) : RuntimeException(message) {
    constructor(id: UUID) : this("Membre avec l'ID $id introuvable")
}
