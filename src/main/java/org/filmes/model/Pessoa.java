package org.filmes.model;

import java.util.Date;

public class Pessoa {

    private String nome;
    private Date dataNascimento;

    public Pessoa(String nome, Date dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
