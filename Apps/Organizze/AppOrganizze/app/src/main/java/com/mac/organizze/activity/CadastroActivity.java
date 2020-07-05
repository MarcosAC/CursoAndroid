package com.mac.organizze.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mac.organizze.R;
import com.mac.organizze.firebasehelper.FirebaseHelper;
import com.mac.organizze.model.Usuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText editNome, editEmail, editSenha;
    private Button btnCadastrar;

    Usuario usuario = new Usuario();

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

                usuario.setNome(editNome.getText().toString());
                usuario.setEmail(editEmail.getText().toString());
                usuario.setSenha(editSenha.getText().toString());

                if (validacaoCampos()) {cadastrarUsuario();}
            }
        });
    }

    private Boolean validacaoCampos() {

        if (usuario.getNome().isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Prencha a nome!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (usuario.getEmail().isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Preencha o email!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (usuario.getSenha().isEmpty()) {
            Toast.makeText(CadastroActivity.this, "Prencha a senha!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void cadastrarUsuario() {

        FirebaseAuth autenticao = FirebaseHelper.getAutenticacao();
        autenticao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                    Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar usuário!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CadastroActivity.this, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}