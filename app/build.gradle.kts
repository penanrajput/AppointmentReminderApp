plugins {
    alias(libs.plugins.android.application)

    id("com.google.gms.google-services")

// or
// id("com.google.gms.google-services") version "4.4.2" apply true

}

android {
    namespace = "academy.penan.appointmentreminderapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "academy.penan.appointmentreminderapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


// Firebase Authentication SDK
    implementation("com.google.firebase:firebase-auth:22.0.0")


// below lines includes the Firebase Core SDK, which is essential for initializing Firebase in your Android app
    implementation("com.google.firebase:firebase-core:21.1.1")

// below line provides a user interface for handling authentication flows
    implementation("com.firebaseui:firebase-ui-auth:8.0.2")

// below line  is for Realtime Database
    implementation("com.google.firebase:firebase-database:21.0.0")

    implementation("com.google.firebase:firebase-auth-ktx:23.0.0")


}