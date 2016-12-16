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
    @BindView(R.id.edit_nome_livro)
    EditText editNomeLivro;
    @BindView(R.id.edit_qtd_pagina)
    EditText editQtdPaginas;
    @BindView(R.id.btn_salvar_livro)
    Button btnSalvarLivro;
    @BindView(R.id.btn_voltar_menu)
    Button btnVoltarMenu;

    File imageFile;
    Livro livro;
    public static final String PRODUCT_KEY = "EDITING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_livro);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_salvar_livro)
    public void salvar(Button button) {
        //String image = imageFile.getAbsolutePath();
        //String image = "Teste";
        String name = editNomeLivro.getText().toString();
        String qtdPagina = editQtdPaginas.getText().toString();

        //Verificação dos campos, se estão nullos ou vazios
        if ((name == null || name.isEmpty()) || (qtdPagina== null || qtdPagina.isEmpty())){
            Toast.makeText(RegisterLivroActivity.this, "Todos campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        }else{
            Livro livro = new Livro();
            livro.setNome(name);
            livro.setQtdPaginas(qtdPagina);
            livro.save();
            Toast.makeText(RegisterLivroActivity.this, "Livro salvo!", Toast.LENGTH_SHORT).show();
            finish();

        }
    }


    @OnClick(R.id.btn_voltar_menu)
    public void sair(Button button) {
        finish();
    }

}
