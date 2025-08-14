plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.4" apply false
	id("io.spring.dependency-management") version "1.1.7"
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}
repositories {
	mavenCentral()
	gradlePluginPortal()
	maven("https://repo.spring.io/release")
}
subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "io.spring.dependency-management")

	repositories {
		mavenCentral()
		gradlePluginPortal()
		maven("https://repo.spring.io/release")
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:3.4.4")
		}
	}

	group = "com.mat.benevolat"
	version = "0.0.1-SNAPSHOT"

	kotlin {
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

//ext["spring-modulith.version"] = "1.1.3"

dependencies {
}
