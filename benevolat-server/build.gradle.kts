plugins {
    kotlin("kapt")
    //id("org.springframework.boot")
}

group = "com.mat.benevolat"
version = "0.0.1-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":benevolat-infra"))
    implementation(project(":benevolat-domaine"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.modulith:spring-modulith-core:1.3.3")
    implementation("org.springframework.modulith:spring-modulith-docs:1.3.3")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.mapstruct:mapstruct:1.6.3")
    kapt("org.mapstruct:mapstruct-processor:1.6.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

sourceSets {
    main {
        java {
            srcDirs("src/main/kotlin")
        }
    }
}
