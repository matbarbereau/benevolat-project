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
        return membreMapper.toModel(membreJpaRepository.save(membreMapper.toEntity(membre)))
    }

    override fun listAll(): List<Membre> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }
}
