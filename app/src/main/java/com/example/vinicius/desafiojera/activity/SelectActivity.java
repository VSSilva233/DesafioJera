package com.example.vinicius.desafiojera.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.example.vinicius.desafiojera.R;
import com.example.vinicius.desafiojera.adapter.LivroListAdapter;
import com.example.vinicius.desafiojera.model.Livro;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by vinicius on 11/12/2016.
 */
public class SelectActivity extends AppCompatActivity {
    @BindView(R.id.list)
    ListView listView;

    private LivroListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao);
        ButterKnife.bind(this);

    }

    @OnLongClick(R.id.list)
    public boolean selecionar(){
        Intent resultData = new Intent();
        resultData.putExtra("codigo", 1);
        setResult(Activity.RESULT_OK, resultData);
        finish();
        return true;
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

