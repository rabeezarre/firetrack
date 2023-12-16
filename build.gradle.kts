plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
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
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	testImplementation("org.springframework.security:spring-security-test")
	implementation ("org.springdoc:springdoc-openapi-ui:1.6.4")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
