// 插件管理配置
pluginManagement {
    // 配置插件仓库
    repositories {
        // 配置 Maven 仓库
        maven {
            // 设置仓库 URL
            url = uri("https://maven.aliyun.com/repository/public")
        }
        // Google 仓库，主要用于 Android 相关依赖
        google {
            // 内容过滤，只包含特定的组
            content {
                // 包含所有 com.android 开头的组
                includeGroupByRegex("com\\.android.*")
                // 包含所有 com.google 开头的组
                includeGroupByRegex("com\\.google.*")
                // 包含所有 androidx 开头的组
                includeGroupByRegex("androidx.*")
            }
        }
        // Maven Central 仓库，是最大的 Java 库和 Android 库的集中地
        mavenCentral()
        // Gradle 插件门户，用于获取 Gradle 插件
        gradlePluginPortal()
    }
}

// 依赖解析管理配置
dependencyResolutionManagement {
    // 设置仓库模式为在项目仓库缺失时失败
    // 这有助于确保所有依赖都来自预定义的仓库
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // 配置依赖仓库
    repositories {
        // 配置 Maven 仓库
        maven {
            // 设置仓库 URL
            url = uri("https://maven.aliyun.com/repository/public")
        }
        // Google 仓库
        google()
        // Maven Central 仓库
        mavenCentral()
    }
}

// 设置根项目名称
// 这个名称通常会显示在 IDE 中，建议使用有意义的名称
rootProject.name = "S04_各种按钮大全_全中文注释"

// 包含 app 模块
// 这表示项目中有一个名为 "app" 的子模块
// 如果有多个模块，可以添加多个 include 语句
include(":app")

// 注意：这个文件是 Gradle 构建系统的核心配置文件之一
// 修改时要小心，因为它会影响整个项目的构建过程
// 可以考虑使用 buildSrc 目录来集中管理依赖和版本
// 对于大型项目，可以考虑使用 Gradle 复合构建来更好地组织多模块项目
