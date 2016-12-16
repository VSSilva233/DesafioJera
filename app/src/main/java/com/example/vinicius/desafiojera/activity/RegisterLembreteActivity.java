package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.model.Lembrete;
import com.example.vinicius.desafiojera.model.Livro;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Vinicius on 14/12/2016.
 */

public class RegisterLembreteActivity extends AppCompatActivity {
    @BindView(R.id.btn_data_lembrete)
    Button btnDataLembrete;
    @BindView(R.id.btn_hora_lembrete)
    Button btnHoraLembrete;
    @BindView(R.id.btn_salvar_lembrete)
    Button btnSalvarLembrete;
    @BindView(R.id.btn_voltar_lista)
    Button btnVoltarMenu;

    Lembrete lembrete;
    Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_lembrete);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_selecionar_livro)
    public void selecionarLivro() {
        Intent intent = new Intent(this, SelectLivroActivity.class);
        startActivityForResult(intent, 90);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String resultado = "1";
        livro.findById(Livro.class, Long.parseLong(resultado));
    }

    @OnClick(R.id.btn_salvar_lembrete)
    public void salvarLembrete(Button button) {
        text. = (Date) dataLembrete.getText();
        Timer hora = (Timer) horaLembrete.getText();
        /*
        //Fazendo verifação dos dados, se são diferentes de null
        if(livro == null ) {
            Toast.makeText(RegisterLembreteActivity.this, "Livro deve ser selecionado", Toast.LENGTH_SHORT).show();
        }else{  Lembrete lembrete = new Lembrete();
                lembrete.setDataLembrete(data);
                lembrete.setHoraLembrete(hora);
                lembrete.setLivro(livro);
                lembrete.save();
                Toast.makeText(RegisterLembreteActivity.this, "Lembrete Salvo!", Toast.LENGTH_SHORT).show();
                finish();
        }
        */
    }

    @OnClick(R.id.btn_voltar_lista)
    public void sair(Button button) {
        finish();
    }
}