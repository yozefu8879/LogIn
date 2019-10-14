package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mail = "mario@gmail.com";
    String password = "123456";
    EditText mailField, passwordField;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputMail = mailField.getText().toString();
                String inputPassword = passwordField.getText().toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(inputMail).matches()) {
                    showErrorMessage(
                            "Ingrese un correo electrónico válido"
                    );
                    return;
                }
                if (!mail.equals(inputMail)) {
                    showErrorMessage(
                            "El correo es inválido"
                    );
                }

                if (!password.equals(inputPassword)) {
                    showErrorMessage(
                            "La contraseña en invalida"
                    );

                    return;

                } else {
                    Intent intent = new Intent(view.getContext(),HomeActivity.class);
                    startActivityForResult(intent,0);
                }


            }

        });
    }
    private void showErrorMessage(String errorMessage) {
        Toast.makeText(
                this,
                errorMessage,
                Toast.LENGTH_SHORT
        ).show();
    }


}
