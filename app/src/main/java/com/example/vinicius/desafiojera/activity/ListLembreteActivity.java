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

/**
 * Created by vinicius on 11/12/2016.
 */
public class ListLembreteActivity extends AppCompatActivity {
    @BindView(R.id.list)
    ListView listView;

    private LembreteListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lembrete);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_cadastro_lembrete)
    public void cadastro(Button button) {
        Intent irParaCadastroLembrete = new Intent(ListLembreteActivity.this, RegisterLembreteActivity.class);
        startActivity(irParaCadastroLembrete);
    }

    private void updateList() {
        List<Lembrete> lembreteList = Lembrete.listAll(Lembrete.class);
        adapter = new LembreteListAdapter(this, lembreteList);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}

