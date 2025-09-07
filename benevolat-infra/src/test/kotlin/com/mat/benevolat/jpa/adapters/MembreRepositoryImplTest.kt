package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.IntegrationTestConfiguration
import com.mat.benevolat.jpa.mother.MembreObjectMother
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
    fun `insert and fetch membre`() {

        val membre = MembreObjectMother.member().build()
        val created: Membre? = this.membreRepository.create(membre)
        assertThat(created).isEqualTo(membre)

        val found: Optional<Membre> = membreRepository.findById(membre.id)
        assertThat(found.get()).isEqualTo(created)
        assertThat(found).isPresent
        assertThat(found.get().prenom).isEqualTo("Mélanie")
    }

    @Test
    fun `get all membres`(){
        val membre1 = MembreObjectMother.member().matricule("M001").id(UUID.randomUUID()).build()
        val membre2 = MembreObjectMother.member().matricule("M002").id(UUID.randomUUID()).build()
        val membre3 = MembreObjectMother.member().matricule("M003").id(UUID.randomUUID()).build()
        membreRepository.create(membre1)
        membreRepository.create(membre2)
        membreRepository.create(membre3)

        val membres: List<Membre> = membreRepository.listAll()
        assertThat(membres).hasSize(3)
        assertThat(membres).containsExactlyInAnyOrder(membre1, membre2, membre3)
    }

    @Test
    fun `delete by id`() {
        val membre = MembreObjectMother.member().build()
        val created: Membre? = this.membreRepository.create(membre)

        membreRepository.deleteById(membre.id)
        assertThat(membreRepository.findById(membre.id)).isNotPresent
    }
}
