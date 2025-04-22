plugins {
}

group = "com.mat.benevolat"
version = "0.0.1-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.modulith:spring-modulith-core:1.3.3")
    implementation("org.springframework.modulith:spring-modulith-docs:1.3.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
sourceSets {
    main {
        java {
            srcDirs("src/main/kotlin")
        }
    }
}
