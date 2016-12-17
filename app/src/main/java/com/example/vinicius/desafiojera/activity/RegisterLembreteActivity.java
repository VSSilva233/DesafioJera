package com.example.vinicius.desafiojera.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.model.Lembrete;
import com.example.vinicius.desafiojera.model.Livro;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterLembreteActivity extends AppCompatActivity {
    static final int ACTIVITY_2_REQUEST = 1; //Criado para o app não se perder ao minimizalo ou abrir outro app;
    //Utilizando ButterKnife para injeção de Views
    @BindView(R.id.edit_data_lembrete)
    EditText editDataLembrete;
    @BindView(R.id.edit_hora_lembrete)
    EditText editHoraLembrete;
    @BindView(R.id.btn_salvar_lembrete)
    Button btnSalvarLembrete;
    @BindView(R.id.btn_voltar_lista)
    Button btnVoltarMenu;

    Lembrete lembrete;
    Livro livro;

    //Chamando/criando layout activity registro(cadastro) de lembretes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_lembrete);
        ButterKnife.bind(this);
    }

    //Criando uma ação/intenção no botão, que é levar para activity selecionar livro
    @OnClick(R.id.btn_selecionar_livro)
    public void selecionarLivro() {
        Intent intent = new Intent(this, SelectLivroActivity.class);
        startActivityForResult(intent, ACTIVITY_2_REQUEST);
    }

    //Verificando se o usuário está no app e se enviou o livro escolhido
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_2_REQUEST) {
            if (resultCode == RESULT_OK) {
                String resultado = data.getStringExtra("resultado");
                //Apresentando ao usuário o livro escolhido
                livro = Livro.findById(Livro.class, Long.parseLong(resultado));
                Toast.makeText(this, "Você selecionou o Livro " + livro.getNome() + "!", Toast.LENGTH_LONG).show();
            }
        }
    }
    //Criando uma ação no botão de pegar os dados fornecidos pelo usuário e salva-los!
    @OnClick(R.id.btn_salvar_lembrete)
    public void salvarLembrete(Button button) {
        String data = editDataLembrete.getText().toString();
        String hora = editHoraLembrete.getText().toString();

        //Fazendo verifação e validações dos dados
        if ((livro == null) || (editHoraLembrete == null) || (editDataLembrete == null)) {
            Toast.makeText(RegisterLembreteActivity.this, "Todos campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        } else {
            Lembrete lembrete = new Lembrete();
            lembrete.setData(data);
            lembrete.setHora(hora);
            lembrete.setLivro(livro);
            lembrete.save();
            Toast.makeText(RegisterLembreteActivity.this, "Lembrete Salvo!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //Criando uma ação no botão de poder voltar para a lista de lembretes!
    @OnClick(R.id.btn_voltar_lista)
    public void sair(Button button) {
        finish();
    }
}