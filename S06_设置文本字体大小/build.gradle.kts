// 顶层构建文件，您可以在此添加适用于所有子项目/模块的配置选项。
plugins {
    
    // 应用 Android 应用程序插件
    // 作用：提供构建 Android 应用所需的任务和配置
    // 优点：简化 Android 应用开发流程
    // 注意：版本由 libs.plugins.android.application 控制，便于统一管理
    alias(libs.plugins.android.application) apply false

    // 应用 Kotlin Android 插件
    // 作用：支持在 Android 项目中使用 Kotlin
    // 优点：启用 Kotlin 特性和编译器
    // 替代方案：可使用 Java，但 Kotlin 更现代化且有更多特性
    // 推荐：Kotlin，因其简洁性和空安全等特性
    alias(libs.plugins.kotlin.android) apply false
    
}