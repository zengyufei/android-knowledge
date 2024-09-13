# 在此处添加项目特定的 ProGuard 规则。
# 作用：定义代码混淆和优化的自定义规则
# 含义：可以保护特定类、方法或字段不被混淆
# 用法：使用 ProGuard 语法编写规则
# 优点：增强应用安全性，减小APK大小
# 缺点：配置不当可能导致运行时错误
# 注意：需要仔细测试以确保应用正常运行
# 可替代：使用其他混淆工具如DexGuard
# 区别：ProGuard是免费的，而DexGuard是商业工具，提供更高级的保护
# 推荐：对大多数项目来说，ProGuard足够使用
# 原因：ProGuard是Android官方支持的工具，使用广泛，文档丰富
# 改动影响：可能需要为第三方库添加keep规则

# 您可以使用build.gradle中的proguardFiles设置来控制应用的配置文件集。
# 作用：指定要使用的ProGuard配置文件
# 用法：在build.gradle文件中设置proguardFiles
# 优点：可以分离通用规则和项目特定规则
# 注意：确保所有必要的规则都被包含

# 更多详细信息，请参见：
#   http://developer.android.com/guide/developing/tools/proguard.html

# 如果您的项目使用带有JS的WebView，请取消注释以下内容
# 并指定JavaScript接口类的完全限定类名：
# 作用：保留WebView中使用的JavaScript接口
# 用法：取消注释并替换fqcn.of.javascript.interface.for.webview为实际类名
# 注意：只有在使用WebView和JavaScript交互时才需要
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# 取消注释此项以保留行号信息，用于调试堆栈跟踪。
# 作用：在混淆后保留源文件和行号信息
# 优点：便于调试发布版本的崩溃
# 缺点：略微增加APK大小
# 推荐：在正式发布前启用，以便于错误报告
#-keepattributes SourceFile,LineNumberTable

# 如果您保留了行号信息，请取消注释此项以隐藏原始源文件名。
# 作用：在保留行号的同时隐藏源文件名
# 用法：与上面的-keepattributes一起使用
# 优点：在保留调试信息的同时增加反编译难度
# 推荐：如果您关心源代码文件名泄露，可以启用此选项
#-renamesourcefileattribute SourceFile