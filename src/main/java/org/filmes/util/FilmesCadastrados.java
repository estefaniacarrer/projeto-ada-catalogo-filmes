package org.filmes.util;

import org.filmes.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmesCadastrados {

    public static List<Filme> listagemDeFilmes() {
        List<Filme> filmes = new ArrayList<>();

        Diretores diretor1 = new Diretores("Christopher Nolan", parseDate("1980-01-01"));
        Diretores diretor2 = new Diretores("James Cameron", parseDate("1990-02-15"));
        Diretores diretor3 = new Diretores("Shane Black", parseDate("1978-08-20"));
        Diretores diretor4 = new Diretores("Chad Stahelski", parseDate("1980-09-23"));

        Atores ator1 = new Atores("Leonardo DiCaprio", parseDate("1995-05-10"));
        Atores ator2 = new Atores("Joseph Gordon", parseDate("1988-12-20"));
        Atores ator3 = new Atores("Zoe Saldana", parseDate("1992-03-25"));
        Atores ator4 = new Atores("Sam Worthington", parseDate("1985-03-27"));
        Atores ator5 = new Atores("Robert Downey", parseDate("1986-09-11"));
        Atores ator6 = new Atores("Gwyneth Paltrow", parseDate("1986-07-10"));
        Atores ator7 = new Atores("Keanu Reeves", parseDate("1978-08-03"));
        Atores ator8 = new Atores("Ian McShane", parseDate("1970-03-14"));

        List<Atores> atoresFilme1 = new ArrayList<>();
        atoresFilme1.add(ator1);
        atoresFilme1.add(ator2);

        List<Atores> atoresFilme2 = new ArrayList<>();
        atoresFilme2.add(ator3);
        atoresFilme2.add(ator4);

        List<Atores> atoresFilme3 = new ArrayList<>();
        atoresFilme3.add(ator5);
        atoresFilme3.add(ator6);

        List<Atores> atoresFilme4 = new ArrayList<>();
        atoresFilme4.add(ator7);
        atoresFilme4.add(ator8);

        Filme filme1 = new Filme("A Origem", parseDate("2010-08-06"), "160 Milhões",
                "Dom Cobb é um ladrão com a rara habilidade de roubar segredos do inconsciente, obtidos durante o estado de sono. Impedido de retornar para sua família, ele recebe a oportunidade de se redimir ao realizar uma tarefa aparentemente impossível: plantar uma ideia na mente do herdeiro de um império. Para realizar o crime perfeito, ele conta com a ajuda do parceiro Arthur, o discreto Eames e a arquiteta de sonhos Ariadne. Juntos, eles correm para que o inimigo não antecipe seus passos.",
                diretor1, atoresFilme1);
        Filme filme2 = new Filme("Avatar", parseDate("2009-12-18"), "237 Milhões",
                "No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos. Como o ambiente do planeta é tóxico, foram criados os avatares, corpos biológicos controlados pela mente humana que se movimentam livremente em Pandora. Jake Sully, um ex-fuzileiro naval paralítico, volta a andar através de um avatar e se apaixona por uma Na'vi. Esta paixão leva Jake a lutar pela sobrevivência de Pandora",
                diretor2, atoresFilme2);
        Filme filme3 = new Filme("Homem de Ferro 3", parseDate("2013-04-26"), "200 Milhões",
                "Depois de um inimigo reduzir o mundo de Tony Stark a destroços, o Homem de Ferro precisa aprender a confiar em seus instintos para proteger aqueles que ama, especialmente sua namorada, e lutar contra seu maior medo: o fracasso.",
                diretor3, atoresFilme3);
        Filme filme4 = new Filme("John Wick", parseDate("2014-11-27"), "120 Milhões",
                "John Wick é um lendário assassino de aluguel aposentado, lidando com o luto após perder o grande amor de sua vida. Quando um gângster invade sua casa, mata seu cachorro e rouba seu carro, ele é forçado a voltar à ativa e inicia sua vingança.",
                diretor4, atoresFilme4);

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
        filmes.add(filme4);

        return filmes;
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

