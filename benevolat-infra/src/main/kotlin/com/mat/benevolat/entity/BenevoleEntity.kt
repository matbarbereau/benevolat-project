package com.mat.benevolat.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.*

@Entity
@Table(name = "benevole")
class BenevoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou AUTO selon le driver
    @Column(columnDefinition = "uuid DEFAULT uuid_generate_v7()")
    var id: UUID? = null
    lateinit var nom: String
    lateinit var prenom: String
}
