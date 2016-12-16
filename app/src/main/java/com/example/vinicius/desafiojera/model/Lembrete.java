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
    Calendar dataTime = Calendar.getInstance();
    private TextView textView;
    private Button btnData;
    private Button btnTime;

    public Calendar getDataTime() {
        return dataTime;
    }

    public void setDataTime(Calendar dataTime) {
        this.dataTime = dataTime;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public Button getBtnData() {
        return btnData;
    }

    public void setBtnData(Button btnData) {
        this.btnData = btnData;
    }

    public Button getBtnTime() {
        return btnTime;
    }

    public void setBtnTime(Button btnTime) {
        this.btnTime = btnTime;
    }

    public Lembrete() {

    }


    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
