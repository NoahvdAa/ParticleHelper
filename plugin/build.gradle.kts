plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

group = "com.owen1212055.particlehelper"
version = parent?.version as String

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(project(":api"))
    compileOnly(project(":nms"))

    implementation("org.bstats:bstats-bukkit:3.0.0")
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    shadowJar {
        dependencies {
            relocate("org.bstats", "com.owen1212055.${rootProject.name}.libs.bstats")
        }
    }

    assemble {
        dependsOn(shadowJar)
    }

    runServer {
        minecraftVersion("1.18.2")
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(
                "version" to version
            )
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}