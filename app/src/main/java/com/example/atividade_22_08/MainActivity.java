package com.example.atividade_22_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button btnAdiciona;
    private ArrayList<Compra> compras = new ArrayList<>();
    private AdapterCompra adaptador;
    private ListView listaCompra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCompra = findViewById(R.id.listaCompra);

        btnAdiciona = (Button) findViewById(R.id.btnAdiciona);
        btnAdiciona.setOnClickListener( new EscutadorBotaoAdiciona());

        Intent i = getIntent();

        Compra c = (Compra) i.getSerializableExtra("compra");

        String nome = c.getNome();
        String marca = c.getMarca();
        String quantidade = c.getQuantidade();

        Compra ca = new Compra(nome, marca, quantidade);
        compras.add(ca);
        adaptador.notifyDataSetChanged();

        listaCompra.setLongClickable(true);
    }

    private class EscutadorCliqueLongo implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){

            return true;
        }
    }

    private class EscutadorBotaoAdiciona implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent i = new Intent( getApplicationContext(), DigitaActivity.class);
            startActivity(i);
        }

    }

}