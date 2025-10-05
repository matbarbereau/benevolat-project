package com.mat.benevolat.http

import com.mat.benevolat.mapper.MembreServerMapper
import com.mat.benevolat.resource.MembreCreateRequest
import com.mat.benevolat.resource.MembreResource
import com.mat.benevolat.service.MembreService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/membres")
class MembreController(private val membreMapper: MembreServerMapper,
                       private val membreService: MembreService) {

    @PostMapping
    fun createMembre(@RequestBody membreCreateRequest: MembreCreateRequest): ResponseEntity<MembreResource> {
        val created  = membreService.createMembre(membreMapper.toModel(membreCreateRequest))
        val response = created?.let { membreMapper.toResource(it) }
        val locationUri = URI.create("/membres/${response?.id}")

        return ResponseEntity
            .created(locationUri)
            .body(response)
    }
}
