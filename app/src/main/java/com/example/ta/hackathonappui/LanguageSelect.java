package com.example.ta.hackathonappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LanguageSelect extends AppCompatActivity {

    String email,password,lang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);
        Intent intent = getIntent();


        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");

    }

    public void selectedHindi(View view) {

        lang = "H";
        newActivityCall();
    }

    private void newActivityCall() {
        Intent intent = new Intent(LanguageSelect.this,ModeSelect.class);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        intent.putExtra("lang",lang);
        startActivity(intent);
    }


    public void selectedEng(View view) {
        lang = "E";
        newActivityCall();
    }


}
