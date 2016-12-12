package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

public class RegisterActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    private void setupView() {
        if (getIntent() != null && getIntent().hasExtra(PRODUCT_KEY)) {
            livro = (Livro) getIntent().getSerializableExtra(PRODUCT_KEY);
            nomeLivro.setText(livro.getNome());
            qtdPaginas.setText(livro.getQtdPaginas());
        } else {
            nomeLivro.getText().clear();
            qtdPaginas.getText().clear();
        }
    }

    @OnClick(R.id.img_livro)
    public void changeImage() {
        imageFile = new File(getFilesDir(), System.currentTimeMillis() + ".jpg");
        imageUri = Uri.fromFile(imageFile);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imagemLivro.setImageBitmap(photo);
        } else {
            Toast.makeText(this, "Imagem não carregada.", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_salvar)
    public void registerProduct() {
        String image = imageFile.getAbsolutePath();
        String name = nomeLivro.getText().toString();
        String page = qtdPaginas.getText().toString();

        Livro livro = new Livro();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(image) && !TextUtils.isEmpty(page)) {
            livro.setImagem(image);
            livro.setNome(name);
            livro.setQtdPaginas(page);
            Toast.makeText(RegisterActivity.this, "Livro salvo!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(RegisterActivity.this, "Todos os campos devem ser preechidos.", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_salvar)
    public void editProduct() {
        String image = imageFile.getAbsolutePath();
        String name = nomeLivro.getText().toString();
        String page = qtdPaginas.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(image) && !TextUtils.isEmpty(page)) {
            Livro livro = new Livro();
            livro.setImagem(image);
            livro.setNome(name);
            livro.setQtdPaginas(page);
            livro.save();
            Toast.makeText(RegisterActivity.this, "Livro salvo!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(RegisterActivity.this, "Todos os campos devem ser preechidos.", Toast.LENGTH_SHORT).show();
        }
    }

}
