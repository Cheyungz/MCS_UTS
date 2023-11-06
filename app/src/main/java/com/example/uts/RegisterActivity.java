package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button registerBTN;
    ImageView backArrow;


    EditText name, email, password, repassword, phoneNumber;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        DB = new DBHelper(this);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        phoneNumber = findViewById(R.id.phoneNumber);

        registerBTN = (Button) findViewById(R.id.registerBTN);
        registerBTN.setOnClickListener(v -> {


            String getName = name.getText().toString();
            String getEmail = email.getText().toString();
            String getPass = password.getText().toString();
            String getRepass = repassword.getText().toString();
            String getPhoneNum =phoneNumber.getText().toString();

            if(getName.isEmpty() || getEmail.isEmpty() || getPass.isEmpty() || getRepass.isEmpty() || getPhoneNum.isEmpty()){
                Toast.makeText(RegisterActivity.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
            }
            else {
                if(getPass.equals(getRepass)){
                    Boolean check = DB.checkEmail(getEmail);

                    if (check == true){
                        Boolean insertUserData = DB.insertUserData(getName, getEmail, getPass, getPhoneNum);
                        
                        if (insertUserData == true){
                            Toast.makeText(RegisterActivity.this, "Account Registered!", Toast.LENGTH_SHORT).show();
                            Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(goToLogin);
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Email already used!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Password doesn't match!", Toast.LENGTH_SHORT).show();
                }
            }


        });



        backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(v -> {
            Intent intent = new Intent (RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}