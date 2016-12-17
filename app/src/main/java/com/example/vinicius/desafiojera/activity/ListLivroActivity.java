package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.adapter.LivroListAdapter;
import com.example.vinicius.desafiojera.model.Livro;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListLivroActivity extends AppCompatActivity {
    //Utilizando ButterKnife para injeção de Views
    @BindView(R.id.list)
    ListView listView;

    private LivroListAdapter adapter;

    //Chamando/criando layout activity livro
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);
        ButterKnife.bind(this);
    }

    //Criando uma ação/intenção no botão, que é levar para activity registro(cadastro) de livros
    @OnClick(R.id.btn_cadastro_livro)
    public void cadastro(Button button) {
        Intent irParaCadastroLivro = new Intent(ListLivroActivity.this, RegisterLivroActivity.class);
        startActivity(irParaCadastroLivro);
    }

    //Atualizando lista de livros
    private void updateList() {
        List<Livro> livroList = Livro.listAll(Livro.class);
        adapter = new LivroListAdapter(this, livroList);
        listView.setAdapter(adapter);
    }

    //Evento chamado para interagir com usuário
    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}

