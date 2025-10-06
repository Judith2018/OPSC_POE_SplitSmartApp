// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

// Top-level build.gradle.kts (project-level)

buildscript {
    dependencies {
        // Firebase plugin (keep it ready for later)
        classpath("com.google.gms:google-services:4.4.1")
    }
}

// No 'repositories' or 'allprojects' blocks here!
// Gradle 8 uses settings.gradle.kts for repository management.



