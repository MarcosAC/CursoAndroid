package com.mac.organizze.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.mac.organizze.R;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editNome, editEmail, editSenha;
    private Button btnCadastrar;
    //private Firebaseauth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
}