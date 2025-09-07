package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.jpa.mapper.MembreMapper
import com.mat.benevolat.model.Membre
import com.mat.benevolat.ports.persistence.MembreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class MembreRepositoryImpl(
    @Autowired
    private val membreJpaRepository: MembreJpaRepository,
    @Autowired(required = true)
    private val membreMapper: MembreMapper)
    :MembreRepository {

    override fun findById(id: UUID): Optional<Membre> {
        return membreJpaRepository.findById(id).map { membreMapper.toModel(it) }
    }

    override fun create(membre: Membre): Membre? {
        return membreMapper.toModel(membreMapper.toEntity(membre)?.let { membreJpaRepository.save(it) })
    }

    override fun listAll(): List<Membre> {
        return membreJpaRepository.findAll().map { membreMapper.toModel(it)!! }
    }

    override fun deleteById(id: UUID) {
        membreJpaRepository.deleteById(id)
    }
}
