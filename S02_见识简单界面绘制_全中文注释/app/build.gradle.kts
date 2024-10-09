// 概述：
// 这是一个 Android 项目的主要构建配置文件，使用 Kotlin DSL 编写。
// 它定义了项目的插件、Android 配置和依赖项。
// 该文件对于 Android 应用程序的构建过程至关重要，控制着编译、打包和依赖管理等方面。

plugins {
    // 应用 Android 应用程序插件
    // 作用：提供构建 Android 应用所需的任务和配置
    // 优点：简化 Android 应用开发流程
    // 注意：版本由 libs.plugins.android.application 控制，便于统一管理
    alias(libs.plugins.android.application)

    // 应用 Kotlin Android 插件
    // 作用：支持在 Android 项目中使用 Kotlin
    // 优点：启用 Kotlin 特性和编译器
    // 替代方案：可使用 Java，但 Kotlin 更现代化且有更多特性
    // 推荐：Kotlin，因其简洁性和空安全等特性
    alias(libs.plugins.kotlin.android)
}
android {
    // 设置应用程序的包名
    // 作用：唯一标识应用程序
    // 注意：更改可能导致应用被视为新应用
    namespace = "com.zyf.demo.S02.ui_test"

    // 设置编译 SDK 版本
    // 作用：指定用于编译应用的 Android SDK 版本
    // 注意：应保持较新以支持最新特性
    compileSdk = 34

    defaultConfig {
        // 设置应用程序 ID
        // 作用：在 Google Play 商店中唯一标识应用
        // 注意：更改会导致应用被视为新应用
        applicationId = "com.zyf.demo.S02.ui_test"

        // 设置最低支持的 SDK 版本
        // 作用：指定应用可以运行的最低 Android 版本
        // 注意：设置过高会减少潜在用户群，设置过低可能增加开发难度
        minSdk = 28

        // 设置目标 SDK 版本
        // 作用：指定应用针对的 Android 版本
        // 建议：与 compileSdk 保持一致，以使用最新特性
        targetSdk = 34

        // 设置应用版本号
        // 作用：用于跟踪应用更新
        // 注意：每次更新应递增
        versionCode = 1

        // 设置应用版本名称
        // 作用：向用户显示的版本信息
        // 注意：应与 versionCode 同步更新
        versionName = "1.0"

        // 设置测试运行器
        // 作用：指定用于运行仪器测试的类
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    signingConfigs {
        create("release") {
            val keystorePath = System.getenv("NOTIFY_ME_KEYSTORE_PATH")
            if (keystorePath.isNullOrEmpty()) {
                throw GradleException("NOTIFY_ME_KEYSTORE_PATH environment variable is not set")
            }

            keyAlias = System.getenv("NOTIFY_ME_KEY_ALIAS")
            keyPassword = System.getenv("NOTIFY_ME_KEY_PASSWORD")
            storeFile = file(keystorePath)
            storePassword = System.getenv("NOTIFY_ME_KEYSTORE_PASSWORD")
        }
    }

    buildTypes {
        release {
            // 是否启用代码混淆
            // 作用：减小 APK 大小，增加反编译难度
            // 缺点：可能导致某些第三方库出问题，需要额外配置
            // 推荐：在正式发布时启用
            isMinifyEnabled = false
            
            signingConfig = signingConfigs.getByName("release")

            // 指定混淆规则文件
            // 作用：定义代码混淆的规则
            // 注意：需要根据项目需求自定义规则
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        // 设置 Java 源代码兼容性
        // 作用：指定源代码使用的 Java 版本
        // 注意：应与项目整体 Java 版本一致
        sourceCompatibility = JavaVersion.VERSION_1_8
        // 设置 Java 字节码兼容性
        // 作用：指定生成的字节码版本
        // 注意：应与 sourceCompatibility 一致
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        // 设置 Kotlin 编译器目标 JVM 版本
        // 作用：指定 Kotlin 代码编译后的 Java 字节码版本
        // 注意：应与 compileOptions 中的版本一致
        jvmTarget = "1.8"
    }
}

dependencies {
    // 以下是项目依赖项配置
    // 作用：声明项目所需的外部库
    // 注意：版本由 libs 变量控制，便于统一管理

    // Android KTX 核心库
    implementation(libs.androidx.core.ktx)
    // AppCompat 支持库
    implementation(libs.androidx.appcompat)
    // Material Design 组件
    implementation(libs.material)
    // Android Activity 库
    implementation(libs.androidx.activity)
    // ConstraintLayout 布局库
    implementation(libs.androidx.constraintlayout)
    // JUnit 测试库
    testImplementation(libs.junit)
    // AndroidX 测试库
    androidTestImplementation(libs.androidx.junit)
    // Espresso UI 测试库
    androidTestImplementation(libs.androidx.espresso.core)
}