package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.adapter.LembreteListAdapter;
import com.example.vinicius.desafiojera.model.Lembrete;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListLembreteActivity extends AppCompatActivity {
    //Utilizando ButterKnife para injeção de Views
    @BindView(R.id.list)
    ListView listView;

    private LembreteListAdapter adapter;

    //Chamando/criando layout activity lembrete
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lembrete);
        ButterKnife.bind(this);
    }

    //Criando uma intenção no botão, que é levar para activity registro(cadastro) de lembretes
    @OnClick(R.id.btn_cadastro_lembrete)
    public void cadastro(Button button) {
        Intent irParaCadastroLembrete = new Intent(ListLembreteActivity.this, RegisterLembreteActivity.class);
        startActivity(irParaCadastroLembrete);
    }

    //Atualizando a lista de lembretes
    private void updateList() {
        List<Lembrete> lembreteList = Lembrete.listAll(Lembrete.class);
        adapter = new LembreteListAdapter(this, lembreteList);
        listView.setAdapter(adapter);
    }

    //Evento chamado para interagir com usuário
    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}

