import java.nio.file.Files
import java.nio.file.StandardCopyOption

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

publishing {
    publications {
        create<org.gradle.api.publish.maven.MavenPublication>("maven") {
            groupId = group as String
            artifactId = "nms"

            from(components["java"])
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}
