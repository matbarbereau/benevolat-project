package com.mat.benevolat.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "benevole")
class BenevoleEntity {
    @Id
    lateinit var id: UUID
    lateinit var nom: String
    lateinit var prenom: String
}
