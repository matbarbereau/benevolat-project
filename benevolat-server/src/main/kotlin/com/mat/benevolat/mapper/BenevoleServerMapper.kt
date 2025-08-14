package com.mat.benevolat.mapper

import com.mat.benevolat.model.Benevole
import com.mat.benevolat.resource.BenevoleResource
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface BenevoleServerMapper {

    fun toResource(benevole: Benevole): BenevoleResource

    fun toModel(resource: BenevoleResource): Benevole

    fun toResourceList(benevoles: List<Benevole>): List<BenevoleResource>
}
