package com.example.vinicius.desafiojera.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by vinicius on 11/12/2016.
 */

public class Livro extends SugarRecord implements Serializable {
    private String nome;
    private String qtdPaginas;
    private String imagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(String qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }


}


