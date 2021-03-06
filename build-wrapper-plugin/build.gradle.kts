/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    `java-gradle-plugin`
    `maven-publish`
}

group = "org.gradle.samples"
version = "1.0"

gradlePlugin {
    (plugins) {
        register("cmakeLibrary") {
            id = "org.gradle.samples.cmake-library"
            implementationClass = "org.gradle.samples.plugins.cmake.CMakeLibraryPlugin"
        }
        register("cmakeApplication") {
            id = "org.gradle.samples.cmake-application"
            implementationClass = "org.gradle.samples.plugins.cmake.CMakeApplicationPlugin"
        }
        register("wrappedBase") {
            id = "org.gradle.samples.wrapped-native-base"
            implementationClass = "org.gradle.samples.plugins.WrappedNativeBasePlugin"
        }
        register("wrappedApplication") {
            id = "org.gradle.samples.wrapped-native-application"
            implementationClass = "org.gradle.samples.plugins.WrappedNativeApplicationPlugin"
        }
        register("wrappedLibrary") {
            id = "org.gradle.samples.wrapped-native-library"
            implementationClass = "org.gradle.samples.plugins.WrappedNativeLibraryPlugin"
        }
        register("autotoolsLibrary") {
            id = "org.gradle.samples.autotools-library"
            implementationClass = "org.gradle.samples.plugins.autotools.AutotoolsLibraryPlugin"
        }
    }
}

tasks.withType<JavaCompile> {
    // strictly compile the sample plugins
    options.compilerArgs.addAll(listOf("-Werror", "-Xlint:deprecation"))
}

publishing {
    repositories {
        maven {
            url = uri("file:../local_maven/repository")
        }
    }
}