plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "benevolat-parent"
include("benevolat-application")
include("benevolat-domaine")
include("benevolat-infra")
