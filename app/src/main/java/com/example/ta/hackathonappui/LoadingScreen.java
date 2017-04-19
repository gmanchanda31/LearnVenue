package com.example.ta.hackathonappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoadingScreen extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);


        textView = (TextView) findViewById(R.id.wait);

        String lang;
        Intent intent = getIntent();
        lang=intent.getStringExtra("lang");

        if(lang.equals("H"))
        {
            textView.setText("प्रतीक्षा करें");
        }

    }
}
