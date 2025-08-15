package com.mat.benevolat.handler

import java.util.*

class BenevoleNotFoundException(message: String) : RuntimeException(message) {
    constructor(id: UUID) : this("Bénévole avec l'ID $id introuvable")
}
