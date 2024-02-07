buildscript {
  dependencies {
    classpath("com.karumi:shot:5.13.0")
  }
}

plugins {
  id("com.android.application") version "7.4.2" apply false
  id("com.android.library") version "7.4.2" apply false
  id("org.jetbrains.kotlin.android") version "1.8.10" apply false
  id("com.vanniktech.maven.publish") version "0.27.0"
  id("org.jetbrains.dokka") version  "1.8.10" apply false
}