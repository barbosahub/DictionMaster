plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Hilt
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.codeplace.dictionary"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.codeplace.dictionary"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        languageVersion = "1.9"
        kotlin.sourceSets.all {
            languageSettings.enableLanguageFeature("DataObjects")
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Splash Screen
    implementation("androidx.core:core-splashscreen:1.0.1")
    // Lottie
    implementation("com.airbnb.android:lottie-compose:6.2.0")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    // Moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    // Dagger-Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    // Kotlin Coroutines
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // Hilt for compose
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    // Style
    implementation("androidx.appcompat:appcompat:1.6.1")
    // Font
    implementation("androidx.compose.ui:ui-text-google-fonts:1.5.4")
    // Google Material for navigation
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    // DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
}

kapt {
    correctErrorTypes = true
}
