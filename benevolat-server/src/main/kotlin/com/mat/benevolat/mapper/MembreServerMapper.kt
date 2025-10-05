package com.mat.benevolat.mapper

import com.mat.benevolat.model.Membre
import com.mat.benevolat.resource.MembreCreateRequest
import com.mat.benevolat.resource.MembreResource
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MembreServerMapper {

    fun toResource(membre: Membre): MembreResource

    fun toModel(resource: MembreCreateRequest): Membre

    fun toResourceList(membres: List<Membre>): List<MembreResource>
}

