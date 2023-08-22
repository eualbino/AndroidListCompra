package com.example.atividade_22_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DigitaActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtMarca;
    private EditText txtQuantidade;
    private Button btnInsere;
    private Button btnCancela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digita);

        txtNome = findViewById(R.id.txtNome);
        txtMarca = findViewById(R.id.txtMarca);
        txtQuantidade = findViewById(R.id.txtQuantidade);
        btnInsere = findViewById(R.id.btnInsere);
        btnCancela = findViewById(R.id.btnCancela);

        btnInsere.setOnClickListener(new EscutadorBotaoInserir());
        btnCancela.setOnClickListener(new EscutadorBotaoCancelar());
    }

    private class EscutadorBotaoInserir implements View.OnClickListener{
        @Override
        public void onClick(View view){
            String nome;
            String marca;
            String quantidade;

            nome = txtNome.getText().toString();
            marca = txtMarca.getText().toString();
            quantidade = txtQuantidade.getText().toString();

            Intent i = new Intent( getApplicationContext(), MainActivity.class);

            i.putExtra("nome", nome);
            i.putExtra("marca", marca);
            i.putExtra("quantidade", quantidade);
            setResult(RESULT_OK, i);

            txtNome.setText("");
            txtMarca.setText("");
            txtQuantidade.setText("");
            finish();
        }
    }

    private class EscutadorBotaoCancelar implements View.OnClickListener{
        @Override
        public void onClick(View view){
            txtNome.setText("");
            txtMarca.setText("");
            txtQuantidade.setText("");
            finish();
        }
    }
}