package com.example.program2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        button=findViewById(R.id.loginBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString();
                String Email=email.getText().toString();
                String Password=password.getText().toString();

                if(Name.isEmpty()||Email.isEmpty()||Password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Fill All The Details", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent=new Intent(MainActivity.this,Homepage.class);
                    intent.putExtra("Name",Name);
                    intent.putExtra("Email",Email);
                    startActivity(intent);
                }



            }
        });
    }
}