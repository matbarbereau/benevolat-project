package com.mat.benevolat.ports.persistence

import com.mat.benevolat.model.Membre
import java.util.*

interface MembreRepository {
    fun findById(id: UUID): Optional<Membre>

    fun create(membre: Membre) : Membre?

    fun listAll(): List<Membre>

    fun deleteById(id: UUID);
}
