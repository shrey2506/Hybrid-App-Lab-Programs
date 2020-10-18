package com.example.program2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        name=findViewById(R.id.homepage_name);
        email=findViewById(R.id.homepage_email);
        button=findViewById(R.id.logOutBtn);

        Bundle bundle=getIntent().getExtras();
        String Name=(String) bundle.get("Name");
        String Email=(String) bundle.get("Email");

        Name="Welcome "+ Name;

        name.setText(Name);
        email.setText(Email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Homepage.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}