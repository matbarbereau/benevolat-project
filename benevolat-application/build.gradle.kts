plugins {
    id("org.springframework.boot")
}

group = "com.mat.benevolat"
version = "0.0.1-SNAPSHOT"

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(project(":benevolat-infra"))
}



