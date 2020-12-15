plugins {
    id("java")
    id("org.springframework.boot") version "2.1.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

version = "1.0.0"

repositories {
    mavenCentral()
}

sourceSets["main"].java.srcDirs("src/main/java", "gen/main/java")

dependencies {
    implementation ("org.springframework.data:spring-data-commons:2.1.4.RELEASE")
    implementation ("org.yaml:snakeyaml:1.23")
    implementation ("org.springframework.boot:spring-boot-starter-web:2.1.4.RELEASE")
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    implementation("org.apache.poi:poi-ooxml:4.1.2")
    implementation("org.apache.poi:poi-scratchpad:4.1.2")
    implementation("org.apache.pdfbox:pdfbox:2.0.6")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.0.3.RELEASE")
    testImplementation("org.springframework.security:spring-security-test:4.0.0.RELEASE")
    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
