package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.entity.MembreEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MembreJpaRepository:  JpaRepository<MembreEntity, UUID>, CrudRepository<MembreEntity, UUID> {

    //override fun findById(id: UUID): Optional<MembreEntity>

}
