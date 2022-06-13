plugins {
    java
    `java-library`
}

group = "com.owen1212055.particlehelper"
version = parent?.version as String

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnlyApi("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))

    withSourcesJar()
    withJavadocJar()
}