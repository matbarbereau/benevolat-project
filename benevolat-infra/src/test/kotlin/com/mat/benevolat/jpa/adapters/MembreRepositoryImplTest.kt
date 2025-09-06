package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.IntegrationTestConfiguration
import com.mat.benevolat.model.Membre
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
import java.util.*

@ActiveProfiles("test")
@DataJpaTest(includeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [Repository::class])])
@ContextConfiguration(classes = [IntegrationTestConfiguration::class])
class MembreRepositoryImplTest(
    @Autowired
    var membreRepository: MembreRepositoryImpl,
    @Autowired
    var membreJpaRepository: MembreJpaRepository
){

    @BeforeEach
    fun setup() {
        membreJpaRepository.deleteAll()
    }

    @Test
    fun insertAndFetchMembre() {
        val membreId = UUID.randomUUID()
        val membre: Membre = Membre(membreId, "M0001", "Sanedanlgarage", "Mélanie")
        val created: Membre? = this.membreRepository.create(membre)
        assertThat(created).isEqualTo(membre)

        val found: Optional<Membre> = membreRepository.findById(membreId)
        assertThat(found.get()).isEqualTo(created)
        assertThat(found).isPresent
        assertThat(found.get().nom).isEqualTo("Sanedanlgarage")
    }
}
