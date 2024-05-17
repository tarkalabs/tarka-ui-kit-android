@file:Suppress("UnstableApiUsage")

plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("maven-publish")
  id("org.jetbrains.dokka")
  id("com.vanniktech.maven.publish")
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

  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.11"
  }
}


publishing {
  publications {
    create<MavenPublication>("gpr") {
      run {
        groupId = "com.tarkalabs"
        artifactId = "tarkaui-icons"
        version = "1.0.3"
        artifact("$buildDir/outputs/aar/tarka-ui-icons-release.aar")
      }
    }
  }

  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/tarkalabs/tarka-ui-kit-android")
      credentials {
        username = System.getenv("GITHUB_USER")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}

dependencies {
  val composeUiVersion = "1.4.1"
  implementation("androidx.compose.runtime:runtime:$composeUiVersion")
  implementation("androidx.compose.ui:ui:$composeUiVersion")
  api("com.microsoft.design:fluent-system-icons:1.1.201@aar")
  implementation("androidx.core:core-ktx:1.10.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}