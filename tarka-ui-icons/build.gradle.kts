plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("maven-publish")
  id("org.jetbrains.dokka")
  id("com.vanniktech.maven.publish")
}

android {
  namespace = "com.tarkalabs.tarkaicons"
  compileSdk = 33

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
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}


publishing {
  publications {
    create<MavenPublication>("gpr") {
      run {
        groupId = "com.tarkalabs"
        artifactId = "tarkaicons"
        version = "1.0.0"
        artifact("$buildDir/outputs/aar/tarkaicons-release.aar")
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

  implementation("androidx.compose.ui:ui:$composeUiVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
  implementation("androidx.compose.material3:material3:1.1.0-rc01")
  implementation("androidx.compose.foundation:foundation:$composeUiVersion")
  api("com.microsoft.design:fluent-system-icons:1.1.201@aar")
  implementation("androidx.core:core-ktx:1.10.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.9.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}