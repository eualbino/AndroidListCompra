package com.example.atividade_22_08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCompra extends ArrayAdapter<Compra> {

    private Context context;
    private ArrayList<Compra> compras;

    public AdapterCompra(Context context, ArrayList<Compra> compras){
        super(context, R.layout.item_lista, compras);
        this.context = context;
        this.compras = compras;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.item_lista, parent, false);

        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblMarca = itemView.findViewById(R.id.lblMarca);
        TextView lblQuantidade = itemView.findViewById(R.id.lblQuantidade);
        TextView lblComprado = itemView.findViewById(R.id.lblComprado);

        lblNome.setText(compras.get(position).getNome());
        lblMarca.setText(compras.get(position).getMarca());
        lblQuantidade.setText(compras.get(position).getQuantidade());

        return itemView;
    }

}
