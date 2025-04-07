package com.mat.benevolat.ports.persistence

import com.mat.benevolat.model.Benevole
import com.mat.benevolat.model.Membre
import java.util.*

interface BenevoleRepository {
    fun findById(id: UUID): Optional<Benevole>

    fun create(benevole: Benevole) : Benevole?

    fun listAll(): List<Benevole>

    fun deleteById(id: UUID);
}
