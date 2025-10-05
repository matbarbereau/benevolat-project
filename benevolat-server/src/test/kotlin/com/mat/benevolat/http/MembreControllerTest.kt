package com.mat.benevolat.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.mat.benevolat.handler.MembreServerExceptionHandler
import com.mat.benevolat.mapper.MembreServerMapper
import com.mat.benevolat.model.Membre
import com.mat.benevolat.resource.BenevoleResource
import com.mat.benevolat.resource.MembreResource
import com.mat.benevolat.service.MembreService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import java.util.*

@TestConfiguration
@Import(MembreController::class, MembreServerExceptionHandler::class)
class MembreCtlTestWebConfig : WebMvcConfigurationSupport() {
    @Bean
    fun objectMapper(): ObjectMapper =
        ObjectMapper().registerModule(KotlinModule.Builder().build())
}

@ExtendWith(SpringExtension::class)
@WebAppConfiguration
@ContextConfiguration(classes = [MembreCtlTestWebConfig::class])
class MembreControllerTest {

    private lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @MockkBean
    lateinit var membreService: MembreService

    @MockkBean
    lateinit var mapper: MembreServerMapper

    private val id = UUID.randomUUID()
    private val membre = Membre(id, "M001","John", "Doe")
    private val membreResource = MembreResource(id, "M001", "John", "Doe")

    @BeforeEach
    fun setup(webApplicationContext: WebApplicationContext) {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build()

        every { membreService.createMembre(any()) } returns membre
        every { mapper.toModel(any()) } returns membre
        every { mapper.toResource(any()) } returns membreResource

    }

    @Test
    fun testCreateMembreOk() {
        mockMvc.perform(
            post("/membres")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(membreResource))
        )
            .andExpect(status().isCreated)
    }

}
