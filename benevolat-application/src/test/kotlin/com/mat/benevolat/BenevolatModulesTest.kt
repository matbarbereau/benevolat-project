package com.mat.benevolat

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModule

import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import java.util.function.Consumer

class BenevolatModulesTest {

    @Test
    fun printModuleMode() {
        val modules: ApplicationModules = ApplicationModules.of(BenevolatApplication::class.java)
        modules.forEach(Consumer<ApplicationModule> { x: ApplicationModule? ->
            println(
                x
            )
        })
    }

    @Test
    fun createModuleDocumentation() {
        val modules: ApplicationModules = ApplicationModules.of(BenevolatApplication::class.java)
        Documenter(modules)
            .writeDocumentation()
            .writeIndividualModulesAsPlantUml()
    }

    @Test
    fun verifiesModularStructure() {
        val modules: ApplicationModules = ApplicationModules.of(BenevolatApplication::class.java)
        modules.verify()
    }
}
