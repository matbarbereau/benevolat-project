plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.mat.benevolat"
version = "0.0.1-SNAPSHOT"

//repositories {
//    mavenCentral()
//}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
}
tasks.bootJar {
    enabled = false
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}


