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

/**
 * Created by vinicius on 11/12/2016.
 */
public class ListLivroActivity extends AppCompatActivity {
    @BindView(R.id.list)
    ListView listView;

    private LivroListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_cadastro)
    public void cadastro(Button button){
        Intent irParaCadastroLivro = new Intent(ListLivroActivity.this, RegisterLivroActivity.class);
        startActivity(irParaCadastroLivro);
    }

    private void updateList() {
        List<Livro> livroList = Livro.listAll(Livro.class);
        adapter = new LivroListAdapter(this, livroList);
        listView.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}

