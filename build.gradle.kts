// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.6.0"
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "org.intellij.sdk"
version = "2.0.0"

repositories {
    maven("https://maven.aliyun.com/repository/spring")
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


java {
    sourceCompatibility = JavaVersion.VERSION_11
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2021.2.4")
}

tasks {
    buildSearchableOptions {
        enabled = false
    }
    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("212")
        untilBuild.set("221.*")
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}



