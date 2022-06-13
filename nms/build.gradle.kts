plugins {
    java
    id("io.papermc.paperweight.userdev") version "1.3.5"
}

group = "com.owen1212055.particlehelper"
version = parent?.version as String

repositories {
    mavenCentral()
}

dependencies {
    paperDevBundle("1.19-R0.1-SNAPSHOT")

    compileOnly(project(":api")) {
        isTransitive = false
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
