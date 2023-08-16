plugins {
    kotlin("jvm")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(project(":businessPeople"))

    implementation("javax.inject:javax.inject:1")
    implementation("org.springframework:spring-web:5.2.0.RELEASE")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // tests
    testImplementation("org.mockito:mockito-core:3.8.0")
    testImplementation("org.mockito:mockito-junit-jupiter:3.8.0")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
}

tasks.test {
    useJUnitPlatform()
}