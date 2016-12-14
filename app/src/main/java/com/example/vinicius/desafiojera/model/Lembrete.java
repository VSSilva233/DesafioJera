package com.example.vinicius.desafiojera.model;

import android.provider.ContactsContract;
import android.widget.ExpandableListView;
import android.widget.Spinner;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Marcelo on 14/12/2016.
 */

public class Lembrete extends SugarRecord implements Serializable {
    private Date dataLembrete;
    private Timer horaLembrete;
    private Livro livro;

    public Lembrete() {

    }




    public Date getDataLembrete() {
        return dataLembrete;
    }

    public void setDataLembrete(Date dataLembrete) {
        this.dataLembrete = dataLembrete;
    }

    public Timer getHoraLembrete() {
        return horaLembrete;
    }

    public void setHoraLembrete(Timer horaLembrete) {
        this.horaLembrete = horaLembrete;
    }



    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
