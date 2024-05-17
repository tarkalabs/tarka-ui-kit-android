buildscript {
  dependencies {
    classpath("com.karumi:shot:5.13.0")
  }
}

plugins {
  id("com.android.application") version "7.4.2" apply false
  id("com.android.library") version "7.4.2" apply false
  id("org.jetbrains.kotlin.android") version "1.9.23" apply false
  id("com.vanniktech.maven.publish") version "0.27.0"
  id("org.jetbrains.dokka") version  "1.9.20" apply false
}

subprojects {
  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
      if (project.findProperty("composeCompilerReports") == "true") {
        freeCompilerArgs += listOf(
          "-P",
          "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=${project.buildDir.absolutePath}/compose_compiler"
        )
      }
      if (project.findProperty("composeCompilerMetrics") == "true") {
        freeCompilerArgs += listOf(
          "-P",
          "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=${project.buildDir.absolutePath}/compose_compiler"
        )
      }
    }
  }
}