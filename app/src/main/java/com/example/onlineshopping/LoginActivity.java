package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText medt_name,medt_password;
    Button mlogin;
    TextView info;
    TextView mTxtRegister;
    private int counter=5;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        medt_name=findViewById(R.id.edt_name);
        info=findViewById(R.id.m_info);
        mTxtRegister=findViewById(R.id.txt_register_now);
        medt_password=findViewById(R.id.edt_password);
        mlogin=findViewById(R.id.btn_login_now);
        info.setText("Number of attempts remaining is 5");

        mTxtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){
            finish();
            startActivity(new Intent(LoginActivity.this,SecondActivity.class));
        }

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(medt_name.getText().toString().trim(),medt_password.getText().toString().trim());

            }
        });



    }

    private void validate(String username,String userpassword){
        progressDialog.setMessage("Wait for verification");
       // progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(username,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,SecondActivity.class));
                }else
                {
                    startActivity(new Intent(LoginActivity.this,SecondActivity.class));
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    counter--;
                    if(counter==0){
                        progressDialog.dismiss();
                        info.setText("Number of attempts remaining: "+counter);
                        mlogin.setEnabled(false);
                    }
                }

            }
        });

    }
}