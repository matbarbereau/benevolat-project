package com.mat.benevolat.service

import com.mat.benevolat.model.Benevole
import com.mat.benevolat.ports.persistence.BenevoleRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BenevoleService(private val benevoleRepository: BenevoleRepository) {

    fun createBenevole(benevole: Benevole): Benevole? {
    return benevoleRepository.create(benevole)
    }

    fun getBenevole(id: UUID) : Benevole? {
        return benevoleRepository.findById(id)
            .orElseThrow { NoSuchElementException("Bénévole non trouvé avec l'id $id") }
    }

    fun getAllBenevoles(): List<Benevole>? {
        return benevoleRepository.listAll()
    }

    fun deleteBenevole(id: UUID) {
        benevoleRepository.deleteById(id)
    }
}
