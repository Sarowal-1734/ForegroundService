package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput = findViewById(R.id.editTextInput);
    }

    public void onStartServiceButtonClicked(View view) {
        String input = editTextInput.getText().toString();
        Intent intent = new Intent(this, ExampleService.class);
        intent.putExtra("inputExtra", input);
        //startService(intent);
        // This is better cause cmd+b to see the reason
        ContextCompat.startForegroundService(this, intent);
    }

    public void onStopServiceButtonClicked(View view) {
        Intent intent = new Intent(this, ExampleService.class);
        stopService(intent);
    }
}