@file:Suppress("UnstableApiUsage")

import java.io.FileInputStream
import java.util.*

plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("maven-publish")
}

android {
  namespace = "com.tarkalabs.common_ui"
  compileSdk = 33

  defaultConfig {
    minSdk = 26
    targetSdk = 33

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
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    compose =  true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
}

val githubProperties = Properties().apply {
  load(FileInputStream(rootProject.file("github.properties")))
}

fun getLibraryArtifactId() = "common-ui"

publishing {
  publications {
    create<MavenPublication>("gpr"){
      run {
        groupId = "tarkalabs"
        artifactId = getLibraryArtifactId()
        version = "0.9-alpha"
        artifact("$buildDir/outputs/aar/${getLibraryArtifactId()}-release.aar")
      }
    }
  }

  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/tarkalabs/eam360-ui-android")
      credentials {
        username = githubProperties["gpr.usr"] as String
        password = githubProperties["gpr.key"] as String
      }
    }
  }
}

dependencies {
  val composeUiVersion = "1.4.0"
  implementation("androidx.core:core-ktx:1.10.0")
  implementation( "androidx.compose.ui:ui:$composeUiVersion")
  implementation( "androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
  implementation( "androidx.compose.material:material:$composeUiVersion")
  implementation("com.google.android.material:material:1.8.0")

  testImplementation( "junit:junit:4.13.2")
  androidTestImplementation( "androidx.test.ext:junit:1.1.5")
  androidTestImplementation( "androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
  androidTestImplementation("org.mockito:mockito-android:4.5.1")
  androidTestImplementation( "androidx.compose.ui:ui-test-junit4:$composeUiVersion")
  debugImplementation( "androidx.compose.ui:ui-tooling:$composeUiVersion")
  debugImplementation( "androidx.compose.ui:ui-test-manifest:$composeUiVersion")
}

