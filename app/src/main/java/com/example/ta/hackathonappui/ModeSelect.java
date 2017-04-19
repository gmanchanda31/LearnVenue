package com.example.ta.hackathonappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeSelect extends AppCompatActivity {

    String email,password,lang,mode;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);

        Intent intent = getIntent();

        btn = (Button) findViewById(R.id.tmode);

        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");
        lang=intent.getStringExtra("lang");

        if(lang.equals("H"))
        {
            btn.setText("दूसरों की मदद करो");
            btn = (Button) findViewById(R.id.lmode);
            btn.setText("मदद लें");
        }

    }

    public void selectedLmode(View view) {
        mode="L";
        callInterest();
    }

    private void callInterest() {

        Intent intent = new Intent(ModeSelect.this,Interests.class);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        intent.putExtra("lang",lang);
        intent.putExtra("mode",mode);
        startActivity(intent);

    }

    public void selectedTmode(View view) {
        mode="T";
        callInterest();
    }
}
