package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email, password, passConf;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        passConf = findViewById(R.id.passwordConf);
        login = findViewById(R.id.login);

        passConf.setEnabled(false);

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String passwordText = password.getText().toString();

                if (!passwordText.isEmpty()) {
                    passConf.setEnabled(true);
                }else{
                    passConf.setEnabled(false);
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String passwordText = password.getText().toString();

                if (!passwordText.isEmpty()){
                    passConf.setEnabled(true);
                }else{
                    passConf.setEnabled(false);
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String useremail = email.getText().toString();
                String userpass = password.getText().toString();
                String userpassConf = passConf.getText().toString();



                if (useremail.endsWith("@gmail.com") && userpass.length() >=8 && userpass.equals(userpassConf) && !useremail.isEmpty() && !userpass.isEmpty() && !userpassConf.isEmpty()){
                    Toast.makeText(MainActivity.this,"Login bem sucedido", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                    passConf.setText("");

                    Intent intent = new Intent(MainActivity.this,emailReceiver.class);
                    intent.putExtra("keyemail", useremail);
                    intent.putExtra("keypass", userpass);
                    startActivity(intent);

                }else {
                    Toast.makeText(MainActivity.this, "tente novamente", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}