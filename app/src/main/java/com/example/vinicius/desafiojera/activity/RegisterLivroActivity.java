package com.example.vinicius.desafiojera.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.model.Livro;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterLivroActivity extends AppCompatActivity {
    //Utilizando ButterKnife para injeção de Views
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

    Livro livro;

    //Chamando/criando layout activity registro(cadastro) de livros
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_livro);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_salvar_livro)
    public void salvar(Button button) {
        String name = editNomeLivro.getText().toString();
        String qtdPagina = editQtdPaginas.getText().toString();

        //Verificação e validação dos dados recebidos pelo usuário
        if ((name == null || name.isEmpty()) || (qtdPagina == null || qtdPagina.isEmpty())) {
            Toast.makeText(RegisterLivroActivity.this, "Todos campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        } else {
            Livro livro = new Livro();
            livro.setNome(name);
            livro.setQtdPaginas(qtdPagina);
            livro.save();
            Toast.makeText(RegisterLivroActivity.this, "Livro salvo!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //Criando uma ação no botão de poder voltar para a lista de livros!
    @OnClick(R.id.btn_voltar_menu)
    public void sair(Button button) {
        finish();
    }

}
