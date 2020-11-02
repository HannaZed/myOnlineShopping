package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText medt_phone,medt_email,medt_name,medt_password;
    Button mbtn_join;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        medt_email=findViewById(R.id.edt_email);
        medt_name=findViewById(R.id.edt_name);
        medt_password=findViewById(R.id.edt_password);
        medt_phone=findViewById(R.id.edt_phone);
        mbtn_join =findViewById(R.id.btn_join);

        firebaseAuth= FirebaseAuth.getInstance();

        mbtn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    //upload data to database
                    String user_email=medt_email.getText().toString().trim();
                    String user_name=medt_name.getText().toString().trim();
                    String user_password=medt_password.getText().toString().trim();
                    String user_phone=medt_phone.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                            }
                            else
                                {

                                Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));

                                }
                        }
                    });

                }
            }
        });
    }
    private Boolean validate(){
        Boolean result=false;
        String name=medt_name.getText().toString();
        String password=medt_password.getText().toString();
        String email=medt_email.getText().toString();
        String phone=medt_phone.getText().toString();
        if(name.isEmpty() | password.isEmpty() | email.isEmpty() | phone.isEmpty()){
            Toast.makeText(this, "Please Enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }
        return true;
    }
}