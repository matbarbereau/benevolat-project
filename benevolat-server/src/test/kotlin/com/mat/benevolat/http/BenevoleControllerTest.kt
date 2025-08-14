package com.mat.benevolat.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.mat.benevolat.mapper.BenevoleServerMapper
import com.mat.benevolat.model.Benevole
import com.mat.benevolat.resource.BenevoleResource
import com.mat.benevolat.service.BenevoleService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*

@TestConfiguration
@EnableWebMvc
@ComponentScan(basePackageClasses = [BenevoleController::class])
class TestWebConfig : WebMvcConfigurer {
    @Bean
    fun objectMapper(): ObjectMapper =
        ObjectMapper().registerModule(KotlinModule.Builder().build())
}

@ExtendWith(SpringExtension::class)
@WebAppConfiguration
@ContextConfiguration(classes = [TestWebConfig::class])
class BenevoleControllerTest {

    private lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @MockkBean
    lateinit var benevoleService: BenevoleService

    @MockkBean
    lateinit var mapper: BenevoleServerMapper

    @BeforeEach
    fun setup(webApplicationContext: WebApplicationContext) {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build()
    }

    @Test
    fun testCreateBenevole() {
        val benevole = Benevole(UUID.randomUUID(), "John", "Doe")

        every { benevoleService.createBenevole(any()) } returns benevole
        every { mapper.toModel(any()) } returns benevole
        every { mapper.toResource(any()) } returns BenevoleResource(UUID.randomUUID(), benevole.prenom, benevole.nom)

        val benevoleResource = BenevoleResource(UUID.randomUUID(), "John", "Doe")

        mockMvc.perform(
            post("/benevoles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(benevoleResource))
        )
            .andExpect(status().isCreated)
    }

    //@Test
    fun testGetBenevole() {
        val id = UUID.randomUUID()
        val benevole = Benevole(id, "John", "Doe")

        every {benevoleService.getBenevole(id)} returns benevole

        mockMvc.perform(get("/benevoles/$id"))
            .andExpect(status().isOk)
    }
}
