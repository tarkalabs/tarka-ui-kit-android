@file:Suppress("UnstableApiUsage")



pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "tarka-ui-kit-android"
include(":example")
include(":tarka-ui")
include(":tarka-ui-icons")
