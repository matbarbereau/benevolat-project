package com.mat.benevolat.http

import com.mat.benevolat.mapper.BenevoleServerMapper
import com.mat.benevolat.resource.BenevoleResource
import com.mat.benevolat.service.BenevoleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/benevoles")
class BenevoleController(private val benevoleMapper: BenevoleServerMapper,
    private val benevoleService: BenevoleService) {

    @PostMapping()
    fun createBenevole(@RequestBody benevoleResource: BenevoleResource ): ResponseEntity<BenevoleResource> {
        val created = benevoleService.createBenevole(benevoleMapper.toModel(benevoleResource))
        val response = created?.let { benevoleMapper.toResources(it) }
        val locationUri = URI.create("/benevoles/${response?.id}")

        return ResponseEntity
            .created(locationUri)
            .body(response)
    }

    @GetMapping("{id}")
    fun getBenevole(@PathVariable id: UUID): ResponseEntity<BenevoleResource> {
        val benevole = benevoleService.getBenevole(id)?.let { benevoleMapper.toResources(it) }
        return ResponseEntity.ok(benevole)
    }

    @GetMapping
    fun getBenevoles(): ResponseEntity<List<BenevoleResource>> {
        val allBenevoles = benevoleService.getAllBenevoles()?.let { benevoleMapper.toResources(it) }
        return ResponseEntity.ok(allBenevoles)
    }

    @DeleteMapping("{id}")
    fun deleteBenevole(@PathVariable id: UUID): ResponseEntity<Void> {
        benevoleService.deleteBenevole(id)
        return ResponseEntity.noContent().build();
    }
}
