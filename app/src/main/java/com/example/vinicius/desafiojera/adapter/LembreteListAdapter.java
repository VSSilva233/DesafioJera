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
import com.example.vinicius.desafiojera.model.Lembrete;
import com.example.vinicius.desafiojera.model.Livro;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vinicius on 11/12/2016.
 */
public class LembreteListAdapter extends ArrayAdapter<Lembrete> {
    public LembreteListAdapter(Context context, List<Lembrete> lembreteList) {
        super(context, R.layout.item_lembrete, lembreteList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_lembrete, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Livro livro;
        final Lembrete lembrete = getItem(position);
        holder.txtDataLembrete.setText(lembrete.getData().toString());
        holder.txtHoraLembrete.setText(lembrete.getHora().toString());
        holder.txtNomeLivro.setText(lembrete.getLivro().getNome().toString());

        Bitmap bm = BitmapFactory.decodeFile(lembrete.getLivro().getImagem());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.img_livro)
        ImageView imagem;
        @BindView(R.id.txt_data_lembrete)
        TextView txtDataLembrete;
        @BindView(R.id.txt_hora_lembrete)
        TextView txtHoraLembrete;
        @BindView(R.id.txt_nome_livro)
        TextView txtNomeLivro;
    }
}