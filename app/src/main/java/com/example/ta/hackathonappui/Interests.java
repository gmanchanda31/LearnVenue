package com.example.ta.hackathonappui;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Interests extends AppCompatActivity {

    String email,password,lang,mode,interest;
    EditText inte;
    TextView textView;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();

        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");
        lang=intent.getStringExtra("lang");
        mode=intent.getStringExtra("mode");

        textView = (TextView)findViewById(R.id.textvw);
        btn = (Button)findViewById(R.id.searchpeer);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        inte = (EditText) findViewById(R.id.interest);




    }


    public void insertDetails(View view) {
        interest = inte.getText().toString();

        if(mode.equals("T"))
        {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference myRef = database.getReference();

            Map<String,String> map = new HashMap<String, String>();
            map.put("Email",email);
            map.put("Password",password);
            map.put("Language",lang);
            map.put("Interest",interest);
            myRef.push().setValue(map);

            Intent intent = new Intent(Interests.this,LoadingScreen.class);
            intent.putExtra("lang",lang);
            startActivity(intent);

            //wait
        }
        else
        {
            String caller;
            if(lang.equals("H"))
            {
                caller="manchanda390";
            }
            else
            {
                caller="a3dd2b30525ce643";
            }

            Uri skypeUri = Uri.parse("skype:live:"+caller+"?call&video=true");
            Intent myIntent = new Intent(Intent.ACTION_VIEW, skypeUri);
            myIntent.setComponent(new ComponentName("com.skype.raider", "com.skype.raider.Main"));
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(myIntent);



        }

    }
}
