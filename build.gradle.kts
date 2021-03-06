plugins {
    kotlin("multiplatform") version "1.4.32"
    kotlin("plugin.serialization") version "1.4.32"
    id("com.codingfeline.buildkonfig") version "0.7.0"
    id("io.gitlab.arturbosch.detekt") version "1.16.0"
}

group = "me.maikv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    // Needed by detekt for html stuff like generating the config file
    jcenter {
        content {
            // Only download the 'kotlinx-html-jvm' module from JCenter, but nothing else.
            // detekt needs 'kotlinx-html-jvm' for the HTML report.
            includeModule("org.jetbrains.kotlinx", "kotlinx-html-jvm")
        }
    }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    js(LEGACY) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    usePhantomJS()
                }
            }
        }
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }
    sourceSets {
        val ktorVersion = "1.5.3"
        val logbackVersion = "1.2.3"
        val coroutinesVersion = "1.4.3"
        val coroutinesNativeVersion = "1.3.8"
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
//                implementation("io.ktor:ktor-client-auth:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
                implementation("io.ktor:ktor-client-mock-jvm:$ktorVersion")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
        val nativeMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesNativeVersion")
            }
        }
        val nativeTest by getting
    }
}

buildkonfig {
    packageName = "me.maikv"

    defaultConfigs {
        val file = rootProject.file("key.properties")

        val keyValuePairs = if (file.exists()) {
            file.readLines().map {
                val splitKeyValue = it.split("=")
                Pair(splitKeyValue[0], splitKeyValue[1])
            }
        } else return@defaultConfigs

        val apiKey = keyValuePairs.first { it.first == "apiKey" }.second
        buildConfigField(com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING, "ApiKey", apiKey)
    }
}
