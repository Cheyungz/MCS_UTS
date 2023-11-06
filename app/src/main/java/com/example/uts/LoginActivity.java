package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class LoginActivity extends AppCompatActivity {

    Button signInBTN,registerBTN;
    DBHelper DB;

    public static Integer userId;


    public static Vector<User> users = new Vector();
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DB = new DBHelper(this);

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);

        signInBTN = (Button) findViewById(R.id.signInBTN);
        signInBTN.setOnClickListener(v -> {


            String getEmail = email.getText().toString();
            String getPass = password.getText().toString();

            if(getEmail.isEmpty() || getPass.isEmpty()){
                Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
            }
            else {
                Integer checkCred = DB.checkEmailPass(getEmail, getPass);
                if(checkCred > 0){
                    userId = checkCred;
                    Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
                }
            }

        });

        registerBTN = (Button) findViewById(R.id.goToRegisterBTN);
        registerBTN.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}