package com.example.vinicius.desafiojera.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.model.Livro;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by vinicius on 11/12/2016.
 */

public class RegisterLivroActivity extends AppCompatActivity {
    public static final int CAMERA_REQUEST = 123;

    Uri imageUri;

    @BindView(R.id.img_livro)
    ImageView imagemLivro;
    @BindView(R.id.nome_livro)
    EditText nomeLivro;
    @BindView(R.id.qtd_pagina)
    EditText qtdPaginas;
    @BindView(R.id.btn_salvar)
    Button btnSalvar;
    @BindView(R.id.btn_voltar)
    Button btnVoltar;

    File imageFile;
    Livro livro;
    public static final String PRODUCT_KEY = "EDITING";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_livro);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_salvar)
    public void salvar(Button button){
        //String image = imageFile.getAbsolutePath();
        String image = "Teste";
        String name = nomeLivro.getText().toString();
        Integer page = Integer.parseInt(qtdPaginas.getText().toString());

        Livro livro = new Livro();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(image) && page!=0) {
            livro.setImagem(image);
            livro.setNome(name);
            livro.setQtdPaginas(page);
            livro.save();
            Toast.makeText(RegisterLivroActivity.this, "Livro salvo!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(RegisterLivroActivity.this, "Todos os campos devem ser preechidos.", Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.btn_voltar)
    public void sair(Button button) {
        finish();
    }

}
