package com.example.vinicius.desafiojera.model;

import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Marcelo on 14/12/2016.
 */

public class Lembrete extends SugarRecord implements Serializable {

    private Livro livro;
    private String data;
    private String hora;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
