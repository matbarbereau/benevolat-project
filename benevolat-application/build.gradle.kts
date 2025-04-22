plugins {
    id("org.springframework.boot")
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
}

sourceSets {
    main {
        java {
            srcDirs("src/main/kotlin")
        }
    }
}

