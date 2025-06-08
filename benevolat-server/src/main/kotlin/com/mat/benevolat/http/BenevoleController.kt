package com.mat.benevolat.http

import com.mat.benevolat.mapper.BenevoleServerMapper
import com.mat.benevolat.resource.BenevoleResource
import com.mat.benevolat.service.BenevoleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/benevoles")
class BenevoleController(private val benevoleMapper: BenevoleServerMapper,
    private val benevoleService: BenevoleService) {

    @PostMapping()
    fun createBenevole(@RequestBody benevoleResource: BenevoleResource ): ResponseEntity<BenevoleResource> {
        val created = benevoleService.create(benevoleMapper.toModel(benevoleResource))
        val response = created?.let { benevoleMapper.toResource(it) }
        val locationUri = URI.create("/benevoles/${response?.id}")

        return ResponseEntity
            .created(locationUri)
            .body(response)
    }

}
