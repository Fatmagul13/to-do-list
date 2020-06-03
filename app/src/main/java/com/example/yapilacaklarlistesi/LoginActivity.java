package com.example.yapilacaklarlistesi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText kullaniciAdi, sifre;
    TextView girisYap, KayitOl;


    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        kullaniciAdi= (EditText) findViewById(R.id.kullaniciAdi);
        sifre= (EditText) findViewById(R.id.Sifre);
        girisYap= (TextView) findViewById(R.id.Giris);
        KayitOl=(TextView)findViewById(R.id.KayitOl);

        mAuth = FirebaseAuth.getInstance();

        girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = kullaniciAdi.getText().toString().trim();
                String userPassword = sifre.getText().toString().trim();
                if (!userEmail.isEmpty() && !userPassword.isEmpty()) {
                    login(userEmail, userPassword);
                } else {
                    Toast.makeText(getApplicationContext(), "Email ya da parola boş bırakılamaz!", Toast.LENGTH_LONG).show();
                }

            }
        });
        KayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent kayitIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(kayitIntent);

            }
        });





    }
    private void login(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("EMail", "signInWithEmail:success");
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Fail", "signInWithEmail:failure", task.getException());

                        }
                    }
                });
    }
}
