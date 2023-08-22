package com.example.atividade_22_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DigitaActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtMarca;
    private EditText txtQuantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digita);

        txtNome = findViewById(R.id.txtNome);
        txtMarca = findViewById(R.id.txtMarca);
        txtQuantidade = findViewById(R.id.txtQuantidade);

    }

    private class EscutadorBotaoInserir implements View.OnClickListener{
        @Override
        public void onClick(View view){
            String nome, marca, quantidade;

            nome = txtNome.getText().toString();
            marca = txtMarca.getText().toString();
            quantidade = txtQuantidade.getText().toString();

            Compra c = new Compra(nome, marca, quantidade);

            Intent i = new Intent( getApplicationContext(), MainActivity.class);
            i.putExtra("compra", c);
            startActivity(i);
        }
    }
}