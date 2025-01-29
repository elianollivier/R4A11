plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.tp2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tp2"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    // -- ACTIVER JETPACK COMPOSE -- //
    buildFeatures {
        compose = true
    }
    // --------------------------------

    // -- VERSION DU COMPILER DE COMPOSE -- //
    composeOptions {
        // Mets la version du Compiler Extension de Compose adaptée
        // à la version de Compose que tu utilises.
        // Par exemple :
        kotlinCompilerExtensionVersion = "1.4.8"
        // (ou celle qui correspond à la dernière version stable,
        // en accord avec le BOM Compose)
    }
    // --------------------------------------   

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Par exemple, en utilisant le BOM de Compose :
    val composeBom = platform("androidx.compose:compose-bom:2023.01.00")
    implementation(composeBom)

    // Dépendances principales pour Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")  // Pour Material 3
    implementation("androidx.activity:activity-compose")     // Pour setContent { }

    // (optionnel) UI Debug Tooling
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Le reste de tes dépendances existantes...
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
