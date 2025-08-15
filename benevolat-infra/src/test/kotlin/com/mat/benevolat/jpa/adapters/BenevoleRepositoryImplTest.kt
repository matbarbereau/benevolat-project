package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.AbstractIntegrationTest
import com.mat.benevolat.model.Benevole
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class BenevoleRepositoryImplTest(
    @Autowired
    var benevoleRepository: BenevoleRepositoryImpl,
    @Autowired
    var benevoleJpaRepository: BenevoleJpaRepository
): AbstractIntegrationTest() {

    @BeforeEach
    fun setup() {
        benevoleJpaRepository.deleteAll()
    }

    @Test
    fun insertAndFetchBenevole() {
        val benevoleId = UUID.randomUUID()
        val benevole: Benevole = Benevole(benevoleId, "Mélanie", "Sanedanlgarage")
        val created: Benevole? = this.benevoleRepository.create(benevole)
        assertThat(created).isEqualTo(benevole)

        val found: Optional<Benevole> = benevoleRepository.findById(benevoleId)
        assertThat(found.get()).isEqualTo(created)
    }
}
