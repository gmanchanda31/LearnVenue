package com.example.ta.hackathonappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText emailid,password;

    Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailid = (EditText) findViewById(R.id.emailid);

        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailid.getText().toString();

                String pwd = password.getText().toString();


                if(email.equals("")||!email.matches("([A-Z]|[a-z]|[0-9])+(@)+.+[a-z]+"))
                {
                    emailid.setError("Enter Correct Email");
                    return;
                }
                if(pwd.equals(""))
                {
                    password.setError("Password is Blank");
                    return;
                }
                if(pwd.length()<=5)
                {
                    password.setError("Password Too Small");
                    return;
                }


                Intent intent = new Intent(MainActivity.this,LanguageSelect.class);
                intent.putExtra("email",email);
                intent.putExtra("password",pwd);

                startActivity(intent);



                /*map.put("Email",email);
                map.put("Password",pwd);
                myRef.push().setValue(map);*/


            }
        });






    }
}
