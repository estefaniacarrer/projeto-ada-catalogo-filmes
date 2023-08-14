package org.filmes.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filme {

    private String nome;
    private Date dataLancamento;
    private double orcamento;
    private String descricao;
    private Diretores diretores;
    private List<Atores> atores = new ArrayList<>();

    public Filme() {
    }

    public Filme(String nome, Date dataLancamento, double orcamento, String descricao, Diretores diretores, List<Atores> atores) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretores = diretores;
        this.atores = atores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretores getDiretores() {
        return diretores;
    }

    public void setDiretores(Diretores diretores) {
        this.diretores = diretores;
    }

    public List<Atores> getAtores() {
        return atores;
    }

    public void setAtores(List<Atores> atores) {
        this.atores = atores;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Data de Lançamento: ").append(sdf.format(dataLancamento)).append("\n");
        sb.append("Orçamento: ").append(orcamento).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        sb.append("Diretor: ").append(diretores.getNome()).append("\n");
        sb.append("Atores:\n");
        for (Atores ator : atores) {
            sb.append("- ").append(ator.getNome()).append("\n");
        }
        return sb.toString();
    }
}
