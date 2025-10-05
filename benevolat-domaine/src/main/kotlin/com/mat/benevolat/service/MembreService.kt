package com.mat.benevolat.service

import com.mat.benevolat.model.Membre
import com.mat.benevolat.ports.persistence.MembreRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MembreService(private val membreRepository: MembreRepository) {

    fun createMembre(membre: Membre): Membre? {
        return membreRepository.create(membre)
    }

    fun getMembre(id: UUID) : Membre? {
        return membreRepository.findById(id)
            .orElseThrow { NoSuchElementException("Bénévole non trouvé avec l'id $id") }
    }

    fun getAllMembres(): List<Membre>? {
        return membreRepository.listAll()
    }

    fun deleteMembre(id: UUID) {
        membreRepository.deleteById(id)
    }
}
