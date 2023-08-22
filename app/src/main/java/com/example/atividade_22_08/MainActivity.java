package com.example.atividade_22_08;

import androidx.annotation.Nullable;
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
    private AdapterCompra adaptador;
    private ListView listaCompra;

    private ArrayList<Compra> compras = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCompra = findViewById(R.id.listaCompra);
        btnAdiciona = findViewById(R.id.btnAdiciona);

        adaptador = new AdapterCompra(this, compras);
        listaCompra.setAdapter(adaptador);



        btnAdiciona.setOnClickListener( new EscutadorBotaoAdiciona());
        EscutadorLista e = new EscutadorLista();
        listaCompra.setOnItemClickListener( e );
        listaCompra.setOnItemLongClickListener( e );
    }

    private class EscutadorLista implements AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Compra c = compras.get(i);
            if(c.getComprado().isEmpty()){
                c.setComprado("*COMPRADO*");
            }else{
                c.setComprado("");
            }
            adaptador.notifyDataSetChanged();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            compras.remove( i );
            adaptador.notifyDataSetChanged();
            return true;
        }
    }


    private class EscutadorBotaoAdiciona implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent i = new Intent( getApplicationContext(), DigitaActivity.class);
            startActivityForResult(i, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( resultCode == RESULT_OK){
            String nome = data.getStringExtra("nome");
            String marca = data.getStringExtra("marca");
            String quantidade = data.getStringExtra("quantidade");

            Compra c = new Compra(nome, marca, quantidade, "");
            compras.add(c);
            adaptador.notifyDataSetChanged();
        }

    }
}