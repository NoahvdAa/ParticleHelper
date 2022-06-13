plugins {
    java
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "com.owen1212055"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":nms"))
}

tasks {
    assemble {
        dependsOn(shadowJar)
    }

    shadowJar {
        archiveClassifier.set("")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = group as String
            artifactId = "particlehelper"

            //from(components["java"])
            artifact(tasks["shadowJar"])
        }
    }
}

publishing {
    repositories {
        maven {
            name = "bytecodespace"

            val releasesRepoUrl = "https://repo.bytecode.space/repository/maven-releases/"
            val snapshotsRepoUrl = "https://repo.bytecode.space/repository/maven-snapshots/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)

            credentials(PasswordCredentials::class)
        }
    }
}