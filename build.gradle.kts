plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("checkstyle")
	id("net.ltgt.errorprone") version "3.1.0"
}

group = "com"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.h2database:h2")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-security")
	testImplementation("org.springframework.security:spring-security-test")
	implementation ("org.springdoc:springdoc-openapi-ui:1.6.4")
	errorprone("com.google.errorprone:error_prone_core:2.24.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

checkstyle {
	toolVersion = "10.12.7"
	configFile = file("config/checkstyle/checkstyle.xml")
}
