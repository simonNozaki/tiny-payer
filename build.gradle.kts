import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "io.github.simonnozaki.tinypayer"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    // Enable 1.7.20 data object: https://kotlinlang.org/docs/whatsnew1720.html#improved-string-representations-for-singletons-and-sealed-class-hierarchies-with-data-objects
    kotlinOptions.languageVersion = "1.8"
}
