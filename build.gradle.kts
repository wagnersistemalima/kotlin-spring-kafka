import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.11"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.sistemalima"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	 // -- Zalando Problem --
	implementation("org.zalando:problem-spring-web-starter:0.27.0")

	// -- SpringDoc OpenAPI --
	implementation("org.springdoc:springdoc-openapi-ui:1.6.10")

	// -- Spring for Kafka --
	implementation("org.springframework.kafka:spring-kafka:2.9.4")

	testImplementation("org.springframework.kafka:spring-kafka-test:2.9.4")

	// -- Awaitility --
	testImplementation("org.awaitility:awaitility:4.2.0")

	// -- JUnit Pioneer --
	testImplementation("org.junit-pioneer:junit-pioneer:1.7.1")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
