package com.mat.benevolat.jpa.mapper

import com.mat.benevolat.entity.BenevoleEntity
import com.mat.benevolat.model.Benevole
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface BenevoleMapper {
    fun toEntity(benevole: Benevole?): BenevoleEntity?
    fun toModel(benevoleEntity: BenevoleEntity?): Benevole?
}
