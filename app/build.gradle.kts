plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.splitsmart_poe"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.splitsmart_poe"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Added dependencies
//    implementation (androidx.appcompat:appcompat:1.6.1)
//    implementation (com.google.android.material:material:1.9.0)
//    implementation (androidx.constraintlayout:constraintlayout:2.1.4)
//    implementation (androidx.recyclerview:recyclerview:1.3.0)
//    implementation (androidx.cardview:cardview:1.0.0)
//    implementation (androidx.core:core-ktx:1.10.1)
//    implementation (androidx.lifecycle:lifecycle-runtime-ktx:2.6.1)
//    implementation (androidx.activity:activity-ktx:1.8.0)

    // Firebase placeholders (Role 1 will add actual versions & apply plugin)
    // implementation 'com.google.firebase:firebase-auth:XX.X.X'
    // implementation 'com.google.firebase:firebase-firestore:XX.X.X'
}

