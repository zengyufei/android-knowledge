package com.zyf.demo.S04.all_btn;

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


/**
 * MainActivity 就像是一个商店的大门，是顾客（用户）进入应用的第一站。
 *
 * 想象一下，这个类就是一家精心设计的商店：
 * 1. 店面（类本身）：吸引顾客进入，给人第一印象。
 * 2. 开门准备（onCreate方法）：每天开店前的准备工作。
 * 3. 商品陈列（setContentView）：按照设计图摆放商品，让顾客一目了然。
 * 4. 橱窗装饰（enableEdgeToEdge）：将商品摆到橱窗边缘，吸引路人注意。
 * 5. 个性化调整（setOnApplyWindowInsetsListener）：根据顾客身高调整商品高度，
 *    就像处理手机上的状态栏和导航栏，确保所有内容都清晰可见。
 *
 * 生命周期：
 * - 启动时机：当用户点击应用图标时，由Android系统在应用初始化阶段创建和启动。
 * - 调用顺序：通常是应用生命周期中第一个被调用的Activity。
 *
 * 代码结构：
 * - 定义位置：位于 app/src/main/java/com/example/myapplication/MainActivity.kt 文件中。
 * - 引用位置：在AndroidManifest.xml文件中被声明为主Activity，并设置为应用的启动入口。
 */
// MainActivity 继承自 AppCompatActivity
// 替代方案：可以继承 ComponentActivity，它是更基础的活动类
// ComponentActivity 优点是更轻量，缺点是缺少 AppCompatActivity 提供的向后兼容性功能
// 推荐使用 AppCompatActivity，因为它提供了更好的跨版本一致性
class MainActivity : AppCompatActivity() {
    /**
     * onCreate 方法是 Activity 生命周期的一部分，用于初始化 Activity。
     *
     * @param savedInstanceState: Bundle? 类型的参数，用于存储 Activity 的先前状态。
     * Bundle 是一个键值对映射，用于在 Activity 重建时保存和恢复数据。
     * 当 Activity 被系统销毁并重新创建时（如屏幕旋转），savedInstanceState 包含了之前保存的状态信息。
     * 如果 Activity 是首次创建，savedInstanceState 为 null。
     */
    // onCreate 方法在活动创建时被调用，用于初始化界面
    // 这就像是店主在开门前做的准备工作
    override fun onCreate(savedInstanceState: Bundle?) {
        // 调用父类的onCreate方法，确保基本的初始化完成
        // 这就像是遵循开店的基本流程
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate");

        // 启用边缘到边缘显示，让应用内容扩展到屏幕边缘
        // 这就像是把商品摆到橱窗边缘，让路过的人更容易看到
        // 替代方案：WindowCompat.setDecorFitsSystemWindows(window, false)
        // 虽然替代方案更直接，但 enableEdgeToEdge() 提供了更多默认行为，更推荐使用
        Log.i("MainActivity", "enableEdgeToEdge");
        enableEdgeToEdge()

        // 设置活动的布局，R.layout.activity_main 指向一个XML布局文件
        // 这就像是按照设计图摆放店内的商品
        // 替代方案：使用 DataBinding 或 ViewBinding
        // 例如：val binding = ActivityMainBinding.inflate(layoutInflater)
        //       setContentView(binding.root)
        // 优点是类型安全和减少 findViewById 的使用，缺点是需要额外配置
        // 对于复杂布局推荐使用 ViewBinding，简单布局可以保持现状
        Log.i("MainActivity", "setContentView(R.layout.activity_main)");
        setContentView(R.layout.activity_main)

        // 为主视图设置窗口插入监听器，处理系统栏（如状态栏、导航栏）
        // 这就像是根据不同顾客的身高，调整商品的摆放高度
        // 替代方案：使用 WindowInsets.setSystemGestureInsets()
        // 虽然替代方案提供更细粒度的控制，但当前方法更简洁，适合大多数情况
        Log.i("MainActivity", "ViewCompat.setOnApplyWindowInsetsListener");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // 获取系统栏的尺寸信息
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // 根据系统栏的尺寸设置视图的内边距，确保内容不被系统栏遮挡
            // 替代方案：使用 ViewCompat.setPaddingRelative()
            // 这在处理从右到左（RTL）布局时更有优势
            // 但对于大多数应用，当前方法已经足够，推荐保持现状
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            // 返回原始的insets对象，保持链式调用
            insets
        }

        // 添加按钮点击和长按事件
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        // 定义需要添加监听器的按钮ID列表
        val buttonIds = listOf(
            R.id.btn_capsule, R.id.btn_rounded, R.id.btn_square,
            R.id.btn_circle, R.id.btn_oval,
            R.id.btn2_capsule, R.id.btn2_rounded, R.id.btn2_square,
            R.id.btn2_circle, R.id.btn2_oval,
            R.id.btn3_capsule, R.id.btn3_rounded, R.id.btn3_square,
            R.id.btn3_circle, R.id.btn3_oval,
            R.id.btn4_capsule, R.id.btn4_rounded, R.id.btn4_square,
            R.id.btn4_circle, R.id.btn4_oval,
            R.id.btn5_capsule, R.id.btn5_rounded, R.id.btn5_square,
            R.id.btn5_circle, R.id.btn5_oval,
            R.id.btn6_capsule,
            R.id.btn7_checkbox,
            R.id.btn7_left, R.id.btn7_right, R.id.btn7_rg, R.id.btn7_rb1, R.id.btn7_rb2
        )

        // 为每个按钮添加点击和长按监听器
        buttonIds.forEach { buttonId ->
            findViewById<View>(buttonId)?.apply {
                setOnClickListener { showToast("${getButtonName(this)} 点击") }
                setOnLongClickListener {
                    showToast("${getButtonName(this)} 长按")
                    true
                }
            }
        }
    }

    private fun getButtonName(view: View): String {
        return when (view.id) {
            R.id.btn_capsule -> "形状组 胶囊形按钮"
            R.id.btn_rounded -> "形状组 圆角按钮"
            R.id.btn_square -> "形状组 直角按钮"
            R.id.btn_circle -> "形状组 圆形按钮"
            R.id.btn_oval -> "形状组 椭圆形按钮"
            R.id.btn2_capsule -> "空心组 胶囊形按钮"
            R.id.btn2_rounded -> "空心组 圆角按钮"
            R.id.btn2_square -> "空心组 直角按钮"
            R.id.btn2_circle -> "空心组 圆形按钮"
            R.id.btn2_oval -> "空心组 椭圆形按钮"
            R.id.btn3_capsule -> "无边框组 胶囊形按钮"
            R.id.btn3_rounded -> "无边框组 圆角按钮"
            R.id.btn3_square -> "无边框组 直角按钮"
            R.id.btn3_circle -> "无边框组 圆形按钮"
            R.id.btn3_oval -> "无边框组 椭圆形按钮"
            R.id.btn4_capsule -> "阴影组 胶囊形按钮"
            R.id.btn4_rounded -> "阴影组 圆角按钮"
            R.id.btn4_square -> "阴影组 直角按钮"
            R.id.btn4_circle -> "阴影组 圆形按钮"
            R.id.btn4_oval -> "阴影组 椭圆形按钮"
            R.id.btn5_capsule -> "左侧图标组 胶囊形按钮"
            R.id.btn5_rounded -> "左侧图标组 圆角按钮"
            R.id.btn5_square -> "左侧图标组 直角按钮"
            R.id.btn5_circle -> "左侧图标组 圆形按钮"
            R.id.btn5_oval -> "左侧图标组 椭圆形按钮"
            R.id.btn6_capsule -> "无文字组 胶囊形按钮"
            R.id.btn7_checkbox -> "其他按钮组 复选框示例"
            R.id.btn7_left -> "其他按钮组 左对齐按钮"
            R.id.btn7_right -> "其他按钮组 右对齐按钮"
            R.id.btn7_rg -> "其他按钮组 右对齐按钮"
            R.id.btn7_rb1 -> "其他按钮组 右对齐按钮"
            R.id.btn7_rb2 -> "其他按钮组 右对齐按钮"
            else -> "未知按钮"
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}