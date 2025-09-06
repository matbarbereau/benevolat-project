package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.IntegrationTestConfiguration
import com.mat.benevolat.model.Benevole
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.stereotype.Repository
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration


@ActiveProfiles("test")
@DataJpaTest(includeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [Repository::class])])
@ContextConfiguration(classes = [IntegrationTestConfiguration::class])
class BenevoleRepositoryImplTest (
    @Autowired
    var benevoleRepository: BenevoleRepositoryImpl,
    @Autowired
    var benevoleJpaRepository: BenevoleJpaRepository
){

    @BeforeEach
    fun setup() {
        benevoleJpaRepository.deleteAll()
    }

    @Test
    fun `insert and fetch benevole`() {
        val benevole = Benevole(null, "Mélanie", "Sanedanlgarage")
        val created = benevoleRepository.create(benevole)

        assertThat(created).isNotNull
        assertThat(created?.id).isNotNull

        val found = benevoleRepository.findById(created!!.id!!)
        assertThat(found).isPresent
        assertThat(found.get()).isEqualTo(created)
        assertThat(found.get().nom).isEqualTo("Sanedanlgarage")
    }
}

