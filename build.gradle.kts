// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.6.0"
    id("org.springframework.boot") version "2.6.7"
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
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.7")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.7")
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



