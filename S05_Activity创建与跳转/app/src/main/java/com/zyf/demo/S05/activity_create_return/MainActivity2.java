package com.zyf.demo.S05.activity_create_return;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("MainActivity2", "onCreate");
        super.onCreate(savedInstanceState);

        Log.i("MainActivity2", "setContentView(R.layout.go_to_activity)");
        setContentView(R.layout.activity_main2);

        Button btn = findViewById(R.id.go_to_activity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "点击跳转 MainActivity", Toast.LENGTH_SHORT).show();

                Log.i("MainActivity2", "btn.setOnClickListener");
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
