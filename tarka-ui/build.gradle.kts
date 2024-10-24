@file:Suppress("UnstableApiUsage")

import java.util.Properties
import java.io.FileInputStream

plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.plugin.compose")
  id("shot")
  id("maven-publish")
  id ("org.jetbrains.dokka")
}

android {
  namespace = "com.tarkalabs.tarkaui"
  compileSdk = 34

  defaultConfig {
    minSdk = 26
    targetSdk = 34

    testInstrumentationRunner = "com.karumi.shot.ShotTestRunner"
    testApplicationId = "com.tarkalabs.tarkaui"
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
  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
  shot {
    tolerance = 0.1
    applicationId = "com.tarkalabs.tarkaui"
  }
  testOptions {
    emulatorSnapshots.maxSnapshotsForTestFailures = 10
  }
  sourceSets {
    getByName("androidTest").assets.srcDir("$projectDir/src/androidTest/java/com/tarkalabs/uicomponents/assets")
  }
}

fun getLibraryArtifactId() = "tarkaui"

publishing {
  publications {
    create<MavenPublication>("gpr") {
      run {
        groupId = "com.tarkalabs"
        artifactId = getLibraryArtifactId()
        version = "1.1.30"
        artifact("$buildDir/outputs/aar/tarka-ui-release.aar")
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
    mavenCentral()
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.13.1")
  implementation(platform("androidx.compose:compose-bom:2024.10.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3:1.2.1")
  implementation("androidx.compose.foundation:foundation")
  api("com.tarkalabs:tarkaui-icons:1.0.5")
  implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.7")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.2.1")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
  api("com.microsoft.design:fluent-system-icons:1.1.239@aar")

  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  androidTestImplementation("org.mockito:mockito-android:4.5.1")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
  debugImplementation ("androidx.compose.ui:ui-tooling")
  androidTestImplementation ("androidx.test:core:1.6.1")

}

