@file:Suppress("UnstableApiUsage")

import java.io.FileInputStream
import java.util.Properties


pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  val localProperties = Properties()
  val localPropertiesFile = File("local.properties")
  if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
  }
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    maven(url = "https://maven.pkg.github.com/tarkalabs/tarka-ui-kit-android") {
      credentials {
        username =
          System.getenv("GITHUB_USER") ?: localProperties.getProperty("GITHUB_USER")
        password =
          System.getenv("GITHUB_TOKEN") ?: localProperties.getProperty("GITHUB_TOKEN")
      }
    }
  }
}
rootProject.name = "tarka-ui-kit-android"
include(":example")
include(":tarka-ui")
include(":tarka-ui-icons")
