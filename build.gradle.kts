plugins {
    java
    id("maven-publish")
}

group = "com.owen1212055.particlehelper"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

subprojects {
    apply(plugin = "maven-publish")
    publishing {
        repositories {
            maven {
                name = "bytecodespace"

                val releasesRepoUrl = "https://repo.bytecode.space/repository/maven-releases/"
                val snapshotsRepoUrl = "https://repo.bytecode.space/repository/maven-snapshots/"
                url = uri(if (parent?.version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

                credentials(PasswordCredentials::class)
            }
        }
    }
}