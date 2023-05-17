@file:Suppress("UnstableApiUsage")
plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("shot")
}

android {
  namespace = "com.tarkalabs.uicomponents"
  compileSdk = 33

  defaultConfig {
    minSdk = 26
    targetSdk = 33

    testInstrumentationRunner = "com.karumi.shot.ShotTestRunner"
    testApplicationId = "com.tarkalabs.uicomponents"
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
  shot {
    tolerance =  0.1
    applicationId = "com.tarkalabs.uicomponents"
  }
  testOptions {
    emulatorSnapshots.maxSnapshotsForTestFailures = 10
  }
}

dependencies {
  val composeUiVersion = "1.4.1"
  implementation("androidx.core:core-ktx:1.10.0")
  implementation( "androidx.compose.ui:ui:$composeUiVersion")
  implementation( "androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
  implementation("androidx.compose.material3:material3:1.1.0-rc01")
  implementation("com.microsoft.design:fluent-system-icons:1.1.201@aar")

  testImplementation( "junit:junit:4.13.2")
  androidTestImplementation( "androidx.test.ext:junit:1.1.5")
  androidTestImplementation( "androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
  androidTestImplementation("org.mockito:mockito-android:4.5.1")
  androidTestImplementation( "androidx.compose.ui:ui-test-junit4:$composeUiVersion")
  debugImplementation( "androidx.compose.ui:ui-tooling:$composeUiVersion")
  debugImplementation( "androidx.compose.ui:ui-test-manifest:$composeUiVersion")
}