package com.mat.benevolat.service

import com.mat.benevolat.model.Benevole
import com.mat.benevolat.ports.persistence.BenevoleRepository
import org.springframework.stereotype.Service

@Service
class BenevoleService(private val benevoleRepository: BenevoleRepository) {

    fun create(benevole: Benevole): Benevole? {
        return benevoleRepository.create(benevole)
    }
}
