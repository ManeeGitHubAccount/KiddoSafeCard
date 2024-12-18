plugins {
    alias(libs.plugins.android.application)
    id ("com.google.gms.google-services")


}

android {
    namespace = "com.example.kiddosafecard"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kiddosafecard"
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //noinspection UseTomlInstead,BomWithoutPlatform
    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    //noinspection UseTomlInstead
    implementation ("com.google.firebase:firebase-analytics")
    //noinspection UseTomlInstead
    implementation ("com.google.firebase:firebase-auth:23.1.0")


}
