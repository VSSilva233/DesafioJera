package com.example.vinicius.desafiojera.adapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.model.Livro;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vinicius on 11/12/2016.
 */
public class LivroListAdapter extends ArrayAdapter<Livro> {
    public LivroListAdapter(Context context, List<Livro> livroList) {
        super(context, R.layout.item_livro,livroList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_livro, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Livro livro = getItem(position);
        holder.nome.setText(livro.getNome());
        holder.valor.setText(livro.getQtdPaginas().toString());
        Bitmap bm = BitmapFactory.decodeFile(livro.getImagem());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.img_livro)
        ImageView imagem;
        @BindView(R.id.nome_livro)
        TextView nome;
        @BindView(R.id.qtd_pagina)
        TextView valor;
    }
}