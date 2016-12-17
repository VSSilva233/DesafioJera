package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.vinicius.desafiojera.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    //Chamando layout activity_main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //Criando uma ação/intenção no botão, que é levar para activity lista de livros
    @OnClick(R.id.btn_list_livros)
    public void livros(Button button) {
        Intent irParaLivros = new Intent(MainActivity.this, ListLivroActivity.class);
        startActivity(irParaLivros);
    }

    //Criando uma ação/intenção no botão, que é levar para activity lista de lembretes
    @OnClick(R.id.btn_list_lembretes)
    public void lembretes(Button button) {
        Intent irParaLembretes = new Intent(MainActivity.this, ListLembreteActivity.class);
        startActivity(irParaLembretes);
    }


}

