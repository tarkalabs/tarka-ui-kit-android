@file:Suppress("UnstableApiUsage")

import java.io.FileInputStream
import java.util.Properties


plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("maven-publish")
  id("org.jetbrains.dokka")
  id("org.jetbrains.kotlin.plugin.compose")
}

android {
  namespace = "com.tarkalabs.tarkaui.icons"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}


publishing {
  publications {
    register<MavenPublication>("gpr") {
      run {
        groupId = "com.tarkalabs"
        artifactId = "tarkaui-icons"
        version = "1.0.5"
        artifact("$buildDir/outputs/aar/tarka-ui-icons-release.aar")
      }
    }
  }

  repositories {
    val localProperties = Properties()
    val localPropertiesFile = File("local.properties")
    if (localPropertiesFile.exists()) {
      localProperties.load(FileInputStream(localPropertiesFile))
    }
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/tarkalabs/tarka-ui-kit-android")
      credentials {
        username =
          System.getenv("GITHUB_USER") ?: localProperties.getProperty("GITHUB_USER")
        password =
          System.getenv("GITHUB_TOKEN") ?: localProperties.getProperty("GITHUB_TOKEN")
      }
    }
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.13.1")
  implementation("androidx.appcompat:appcompat:1.7.0")
  implementation(platform("androidx.compose:compose-bom:2024.10.00"))
  implementation("androidx.compose.runtime:runtime")
  implementation("androidx.compose.ui:ui")
  api("com.microsoft.design:fluent-system-icons:1.1.239@aar")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.2.1")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}