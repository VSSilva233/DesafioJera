package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.model.Lembrete;
import com.example.vinicius.desafiojera.model.Livro;

import java.util.Date;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Marcelo on 14/12/2016.
 */

public class RegisterLembreteActivity extends AppCompatActivity {
    @BindView(R.id.data_lembrete)
    EditText dataLembrete;
    @BindView(R.id.hora_lembrete)
    EditText horaLembrete;
    @BindView(R.id.btn_salvar_lembrete)
    Button btnSalvarLembrete;
    @BindView(R.id.btn_voltar)
    Button btnVoltarMenu;


    Lembrete lembrete;

    Livro livro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_lembrete);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_selecionar)
    public void selecionarLivro(){
        Intent intent = new Intent(this, SelectActivity.class);
        startActivityForResult(intent, 90);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String resultado="1";
        livro.findById(Livro.class, Long.parseLong(resultado));
    }

    @OnClick(R.id.btn_salvar_lembrete)
    public void salvarLembrete(Button button) {
        Date data = (Date) dataLembrete.getText();
        Timer hora = (Timer) horaLembrete.getText();

        lembrete.setDataLembrete(data);
        lembrete.setHoraLembrete(hora);
        //se o livro for null
        lembrete.setLivro(livro);
        lembrete.save();
    }

    @OnClick(R.id.btn_voltar)
    public void sair(Button button) {
        finish();
    }
}