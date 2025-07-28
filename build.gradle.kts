group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    id("org.springframework.boot").version("3.3.5")
    id("io.spring.dependency-management").version("1.1.7")
}

java {
    toolchain {
       languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.5.2.Final")
    implementation("com.h2database:h2:2.2.224")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}