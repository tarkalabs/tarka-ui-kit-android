@file:Suppress("UnstableApiUsage")
plugins {
  id ("com.android.application")
  id ("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.plugin.compose")
}

android {
  namespace = "com.tarkalabs.ui"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.tarkalabs.ui"
    minSdk = 26
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
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
}

dependencies {
  val composeUiVersion = "1.4.1"
  
  implementation(project(":tarka-ui"))
  implementation("com.tarkalabs:tarkaui-icons:1.0.5")
  implementation("com.microsoft.design:fluent-system-icons:1.1.239@aar")
  implementation("androidx.core:core-ktx:1.10.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
  implementation("androidx.activity:activity-compose:1.7.1")
  implementation("androidx.compose.ui:ui:$composeUiVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
  implementation ("androidx.compose.material3:material3:1.2.0")

  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
  androidTestImplementation("org.mockito:mockito-android:4.5.1")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeUiVersion")
  debugImplementation("androidx.compose.ui:ui-tooling:$composeUiVersion")
  debugImplementation("androidx.compose.ui:ui-test-manifest:$composeUiVersion")
}