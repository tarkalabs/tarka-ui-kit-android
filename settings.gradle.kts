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
    maven(url = "https://maven.pkg.github.com/tarkalabs/tarka-ui-kit-android") {
      credentials {
        username = System.getenv("GITHUB_USER")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}
rootProject.name = "tarka-ui-kit-android"
include(":example")
include(":tarka-ui")
include(":tarka-ui-icons")
