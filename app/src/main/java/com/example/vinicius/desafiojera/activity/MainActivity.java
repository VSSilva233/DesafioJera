package com.example.vinicius.desafiojera.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.adapter.LivroListAdapter;
import com.example.vinicius.desafiojera.model.Livro;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vinicius on 11/12/2016.
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.list)
    ListView listView;
    @BindView(R.id.novo_cadastro)
    Button btnNovoCadastro;

    private LivroListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int
                    position, long l) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class).putExtra(RegisterActivity.PRODUCT_KEY,
                        adapter.getItem(position)));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(MainActivity.this).setTitle("Excluir")
                        .setMessage("Deseja realmente excluir esse livro?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Livro livro = adapter.getItem(position);
                                livro.delete();
                                updateList();
                            }
                        }).show();
                return true;
            }
        });
    }

    private void updateList() {
        List<Livro> userList = Livro.listAll(Livro.class);
        adapter = new LivroListAdapter(this, userList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}

