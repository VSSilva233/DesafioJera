package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.vinicius.desafiojera.R;


import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by vinicius on 11/12/2016.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_livros)
    public void livros(Button button){
        Intent irParaLivros = new Intent(MainActivity.this, ListLivroActivity.class);
        startActivity(irParaLivros);
    }

    @OnClick(R.id.btn_lembretes)
    public void lembretes(Button button){
        Intent irParaLembretes = new Intent(MainActivity.this, ListLembreteActivity.class);
        startActivity(irParaLembretes);
    }


}

