package com.erenyel.itiraffm_giris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Giris_Ekrani extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText emailText;
    EditText parolaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        emailText = findViewById(R.id.emailText);
        parolaText = findViewById(R.id.parolaText);

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
            Intent intent = new Intent(Giris_Ekrani.this,Anasayfa.class);
            startActivity(intent);
            finish();
        }

    }

    public void girisyap(View view){

        String email = emailText.getText().toString();
        String parola = parolaText.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,parola).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(Giris_Ekrani.this,Anasayfa.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Giris_Ekrani.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void kayitol(View view){

        Intent intent = new Intent(Giris_Ekrani.this,Kayit_Ekrani.class);
        startActivity(intent);

    }

}
