package com.zyf.demo.S02.ui_test

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity

class TableLayoutActivity : AppCompatActivity() {
    /**
     * onCreate 方法是 Activity 生命周期的一部分，用于初始化 Activity。
     *
     * @param savedInstanceState: Bundle? 类型的参数，用于存储 Activity 的先前状态。
     * Bundle 是一个键值对映射，用于在 Activity 重建时保存和恢复数据。
     * 当 Activity 被系统销毁并重新创建时（如屏幕旋转），savedInstanceState 包含了之前保存的状态信息。
     * 如果 Activity 是首次创建，savedInstanceState 为 null。
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_layout)
        
        
        // 设置返回按钮
        // 这行代码不会在界面上直接显示返回按钮，而是在ActionBar（应用程序的顶部栏）上显示返回箭头
        // 如果你没看到返回按钮，可能是因为你的主题没有ActionBar，或者你使用了自定义的Toolbar
        // 主题通常在 res/values/themes.xml 文件中定义
        // 在这个项目中，我们可以看到主题被设置为 Theme.Material3.DayNight.NoActionBar
        // 这个主题默认是没有 ActionBar 的，所以我们需要在代码中手动添加 Toolbar 或者更改主题
        
        // 要修改res/values/themes.xml的主题以添加ActionBar，请按以下步骤操作：
        // 1. 打开res/values/themes.xml文件
        // 2. 将主题的parent属性从"Theme.Material3.DayNight.NoActionBar"改为"Theme.Material3.DayNight"
        // 例如：
        // <style name="Base.Theme.MyApplication" parent="Theme.Material3.DayNight">
        //     <!-- 其他主题属性 -->
        // </style>
        // 3. 保存文件并重新构建项目
        // 修改后，ActionBar将会显示，并且以下代码将生效：
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // 注意：如果你想在某些特定的Activity中隐藏ActionBar，可以在该Activity的onCreate方法中调用：
        // supportActionBar?.hide()

        // 添加返回按钮的点击监听器
        onBackPressedDispatcher.addCallback(this) {
            finish()
        }
    }
}