package com.mat.benevolat.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "membre")
class MembreEntity {
    @Id
    lateinit var id: UUID
    lateinit var matricule: String
    lateinit var nom: String
    lateinit var prenom: String
}
