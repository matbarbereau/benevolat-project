plugins {
    kotlin("kapt")
    id("org.flywaydb.flyway") version "10.15.2"
}

group = "com.mat.benevolat"
version = "0.0.1-SNAPSHOT"


dependencies {
    implementation(project(":benevolat-domaine"))
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":benevolat-domaine"))
    implementation("org.flywaydb:flyway-core:10.15.2")
    implementation("org.flywaydb:flyway-database-postgresql:10.15.2")
    implementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:postgresql:1.20.0")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    //runtimeOnly("org.postgresql:postgresql:42.7.1")
    implementation("org.postgresql:postgresql:42.7.1")
    implementation("org.mapstruct:mapstruct:1.6.3")
    kapt("org.mapstruct:mapstruct-processor:1.6.3")
    implementation("org.springframework.modulith:spring-modulith-core:1.3.3")
    implementation("org.springframework.modulith:spring-modulith-docs:1.3.3")
    testImplementation ("org.testcontainers:postgresql:1.21.3")

}

flyway {
    url = "jdbc:postgresql://localhost:5434/benevolat"
    user = "benevolat"
    password = "benevolat"
    locations = arrayOf("classpath:db/migration")
}

sourceSets {
    main {
        java {
            srcDirs("src/main/kotlin")
        }
    }
}
