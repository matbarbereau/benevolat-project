package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.jpa.mapper.BenevoleMapper
import com.mat.benevolat.model.Benevole
import com.mat.benevolat.ports.persistence.BenevoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class BenevoleRepositoryImpl(
    @Autowired
    private val benevoleJpaRepository: BenevoleJpaRepository,
    @Autowired(required = true)
    private val benevoleMapper: BenevoleMapper
    ): BenevoleRepository {
    override fun findById(id: UUID): Optional<Benevole> {
        return benevoleJpaRepository.findById(id).map { benevoleMapper.toModel(it) }
    }

    override fun create(benevole: Benevole): Benevole? {
        return benevoleMapper.toModel(benevoleJpaRepository.save(benevoleMapper.toEntity(benevole)))
    }

    override fun listAll(): List<Benevole> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }
}
