package com.mat.benevolat.jpa.adapters

import com.mat.benevolat.AbstractIntegrationTest
import com.mat.benevolat.model.Membre
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class MembreRepositoryImplTest(
    @Autowired
    var membreRepository: MembreRepositoryImpl,
    @Autowired
    var membreJpaRepository: MembreJpaRepository
): AbstractIntegrationTest() {

    @BeforeEach
    fun setup() {
        membreJpaRepository.deleteAll()
    }

    @Test
    fun insertAndFetchMembre() {
        val membreId = UUID.randomUUID()
        val membre: Membre = Membre(membreId, "M0001", "Mélanie", "Sanedanlgarage")
        val created: Membre? = this.membreRepository.create(membre)
        assertThat(created).isEqualTo(membre)

        val found: Optional<Membre> = membreRepository.findById(membreId)
        assertThat(found.get()).isEqualTo(created)
    }
}
