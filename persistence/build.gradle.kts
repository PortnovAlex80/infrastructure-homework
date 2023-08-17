plugins {
    kotlin("jvm")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.apache.logging.log4j:log4j-core:2.17.2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.2.1.BUILD-SNAPSHOT")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // tests
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0") // adjust the version number if necessary
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(project(mapOf("path" to ":")))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1") // align this version with others

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.2.1.BUILD-SNAPSHOT")

    testImplementation ("org.testcontainers:testcontainers:1.17.3")
    testImplementation("org.testcontainers:junit-jupiter:1.17.3")
    testImplementation ("org.testcontainers:postgresql:1.17.3")
}

tasks.test {
    useJUnitPlatform()
}
