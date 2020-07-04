package com.mac.organizze.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mac.organizze.R;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editNome, editEmail, editSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String textNome = editNome.getText().toString();
                String textEmail = editEmail.getText().toString();
                String textSenha = editSenha.getText().toString();*/

                if (validacaoCampos()) {cadastrarUsuario();};
            }
        });
    }

    private Boolean validacaoCampos() {

        if (editNome.getText().toString().isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Prencha a nome!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editEmail.getText().toString().isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Preencha o email!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (editSenha.getText().toString().isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Prencha a senha!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void cadastrarUsuario() {
        Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar usuário :D", Toast.LENGTH_SHORT).show();
    }
}