package com.zyf.demo.S06.set_text_size;

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var helloWorldTextView1: TextView // 使用px单位
    private lateinit var helloWorldTextView2: TextView // 使用dp单位
    private lateinit var helloWorldTextView3: TextView // 使用sp单位
    private lateinit var fontSizeSeekBar: SeekBar
    private lateinit var fontSizeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MainActivity", "onCreate");
        super.onCreate(savedInstanceState)

        Log.i("MainActivity", "setContentView(R.layout.activity_main)");
        setContentView(R.layout.activity_main)

        helloWorldTextView1 = findViewById(R.id.helloWorldTextView1)
        helloWorldTextView2 = findViewById(R.id.helloWorldTextView2)
        helloWorldTextView3 = findViewById(R.id.helloWorldTextView3)

        fontSizeSeekBar = findViewById(R.id.fontSizeSeekBar)
        fontSizeTextView = findViewById(R.id.fontSizeTextView)

        fontSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val fontSize = progress + 15 // 最小字体大小为15
                
                // 设置使用px单位的TextView
                helloWorldTextView1.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize.toFloat())
                
                // 设置使用dp单位的TextView
                helloWorldTextView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSize.toFloat())
                
                // 设置使用sp单位的TextView
                helloWorldTextView3.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize.toFloat())
                
                fontSizeTextView.text = "当前字体大小: $fontSize"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}