package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void onclick_Calcular(View view) {

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        if (validaCampos(precoAlcool, precoGasolina)) {
            Double resultado = Double.parseDouble(precoAlcool) / Double.parseDouble(precoGasolina);

            if (resultado >= 0.7) {
                textResultado.setText("Melhor utilizar Gasolina");
            }else {
                textResultado.setText("Melhor utilizar Álcool");
            }
        }else {
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    private Boolean validaCampos(String precoAlcool, String precoGasolina) {

        Boolean camposValidos = true;

        if (precoAlcool == null || precoAlcool.equals("") || precoGasolina == null || precoGasolina.equals("")) {
            camposValidos = false;
        }

        return camposValidos;

    }
}