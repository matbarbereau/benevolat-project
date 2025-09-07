package com.mat.benevolat.jpa.mother

import com.mat.benevolat.model.Membre
import java.util.*

class MembreObjectMother {
    companion object {
        fun member(): Builder = Builder()
    }

    class Builder {
        private var id: UUID = UUID.fromString("550e8400-e29b-41d4-a716-446655440000")
        private var matricule: String = "M001234"
        private var prenom: String = "Mélanie"
        private var nom: String = "Sanedanlgarage"

        fun id(id: UUID):Builder = apply { this.id = id }
        fun matricule(matricule: String):Builder = apply { this.matricule = matricule }
        fun prenom(prenom: String):Builder = apply { this.prenom = prenom }
        fun nom(nom: String):Builder = apply { this.nom = nom }

        fun build(): Membre {
           val membre = Membre(id, matricule, prenom, nom)
           return membre
        }
    }

    fun unMembre() = Membre(
        id = UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
        matricule = "M001234",
        prenom = "Jean",
        nom = "Dupont"
    )

    fun unMembreAvecId(id: UUID) = unMembre().copy(id = id)

    fun unMembreAvecMatricule(matricule: String) = unMembre().copy(matricule = matricule)

    fun unMembreAvecPrenom(prenom: String) = unMembre().copy(prenom = prenom)

    fun unMembreAvecNom(nom: String) = unMembre().copy(nom = nom)

    fun unMembreAvecNomComplet(prenom: String, nom: String) = unMembre().copy(
        prenom = prenom,
        nom = nom
    )

    fun unMembreAvec(
        id: UUID = UUID.fromString("550e8400-e29b-41d4-a716-446655440000"),
        matricule: String = "M001234",
        prenom: String = "Jean",
        nom: String = "Dupont"
    ) = Membre(id, matricule, prenom, nom)

    fun unMembreAvecIdAleatoire() = unMembre().copy(id = UUID.randomUUID())

    fun uneListe() = listOf(
        unMembreAvec(
            id = UUID.fromString("550e8400-e29b-41d4-a716-446655440001"),
            matricule = "M001001",
            prenom = "Jean",
            nom = "Dupont"
        ),
        unMembreAvec(
            id = UUID.fromString("550e8400-e29b-41d4-a716-446655440002"),
            matricule = "M001002",
            prenom = "Marie",
            nom = "Martin"
        ),
        unMembreAvec(
            id = UUID.fromString("550e8400-e29b-41d4-a716-446655440003"),
            matricule = "M001003",
            prenom = "Pierre",
            nom = "Durand"
        )
    )
}
