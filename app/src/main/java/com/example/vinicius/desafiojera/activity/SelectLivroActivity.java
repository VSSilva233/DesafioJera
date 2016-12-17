package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.adapter.LivroListAdapter;
import com.example.vinicius.desafiojera.model.Livro;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectLivroActivity extends AppCompatActivity {
    //Utilizando ButterKnife para injeção de Views
    @BindView(R.id.list)
    ListView listView;

    private LivroListAdapter adapter;
    //Chamando/criando layout activity selecao de livro
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_livro);
        ButterKnife.bind(this);

        //Criando um método para pegar o Id do Livro que o usuário escolher
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Livro obj= (Livro) listView.getAdapter().getItem(position);
                String resultado = obj.getId().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("resultado", resultado);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
    //Atualizando Lista de Livros
    private void updateList() {
        List<Livro> userList = Livro.listAll(Livro.class);
        adapter = new LivroListAdapter(this, userList);
        listView.setAdapter(adapter);
    }

    //Evento chamado para interagir com usuário
    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}

