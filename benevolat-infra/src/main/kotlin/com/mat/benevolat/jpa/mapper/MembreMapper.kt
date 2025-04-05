package com.mat.benevolat.jpa.mapper

import com.mat.benevolat.entity.MembreEntity
import com.mat.benevolat.model.Membre
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface MembreMapper {
    fun toEntity(membre: Membre?): MembreEntity?
    fun toModel(membreEntity: MembreEntity?): Membre?
}

