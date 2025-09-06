package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.entity.BenevoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BenevoleJpaRepository: JpaRepository<BenevoleEntity, UUID>, CrudRepository<BenevoleEntity, UUID> {
}
