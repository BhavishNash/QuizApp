package com.example.quizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.example.quizapp.R;

public class IntroActivity extends AppCompatActivity {
    int currentdaynight;
    public static final int splash_screen_timer = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //  setTheme(R.style.dark_theme);
        super.onCreate(savedInstanceState);
        currentdaynight= AppCompatDelegate.getDefaultNightMode();
        setContentView(R.layout.activity_intro);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, StartScreen.class);
                startActivity(intent);
            }
        }, splash_screen_timer);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(currentdaynight!=AppCompatDelegate.getDefaultNightMode()){
            recreate();
        }
    }
}