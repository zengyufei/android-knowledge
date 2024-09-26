package com.zyf.demo.S05.activity_create_return;

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MainActivity", "onCreate");
        super.onCreate(savedInstanceState)

        Log.i("MainActivity", "setContentView(R.layout.activity_main)");
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.go_to_activity2).setOnClickListener {
            Toast.makeText(this, "点击跳转 MainActivity2", Toast.LENGTH_SHORT).show()

            Log.i("MainActivity", "btn.setOnClickListener");
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

}