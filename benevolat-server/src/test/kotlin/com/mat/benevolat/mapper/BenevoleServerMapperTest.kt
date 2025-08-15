package com.mat.benevolat.mapper

import com.mat.benevolat.model.Benevole
import com.mat.benevolat.resource.BenevoleCreateRequest
import org.junit.jupiter.api.Test
import java.util.UUID

class BenevoleServerMapperTest {

    private var benevoleServerMapper = BenevoleServerMapperImpl()

    @Test
    fun testToResource() {
        val id = UUID.randomUUID()
        val benevole  = Benevole(id, "John", "Doe")
        val resource = benevoleServerMapper.toResource(benevole)

        assert(resource.prenom == "John")
        assert(resource.nom == "Doe")
        assert(resource.id == id)
    }

    @Test
    fun testToModel() {
        val id = UUID.randomUUID()
        val benevoleCreateRequest = BenevoleCreateRequest("John", "Doe")
        val benevole = benevoleServerMapper.toModel(benevoleCreateRequest)

        assert(benevole.prenom == "John")
        assert(benevole.nom == "Doe")
    }

    @Test
    fun testToResourceList() {
        val id1 = UUID.randomUUID()
        val id2 = UUID.randomUUID()
        val benevole1 = Benevole(id1, "John", "Doe")
        val benevole2 = Benevole(id2, "Jane", "Smith")
        val benevoles = listOf(benevole1, benevole2)

        val resources = benevoleServerMapper.toResourceList(benevoles)

        assert(resources.size == 2)
        assert(resources[0].prenom == "John")
        assert(resources[0].nom == "Doe")
        assert(resources[0].id == id1)
        assert(resources[1].prenom == "Jane")
        assert(resources[1].nom == "Smith")
        assert(resources[1].id == id2)
    }

}
