plugins {
    kotlin("jvm") version "2.1.20"
}

group = "dev.httpmarco.polocloud"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(libs.bundles.proto)
    implementation(libs.grpc.netty)
    implementation(project(":proto"))

    implementation(libs.bundles.terminal)
    implementation(libs.bundles.runtime)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}