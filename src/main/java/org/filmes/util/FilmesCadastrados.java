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

        Atores ator1 = new Atores("Leonardo DiCaprio", parseDate("1995-05-10"));
        Atores ator2 = new Atores("Joseph Gordon", parseDate("1988-12-20"));
        Atores ator3 = new Atores("Zoe Saldana", parseDate("1992-03-25"));
        Atores ator4 = new Atores("Sam Worthington", parseDate("1992-03-25"));

        List<Atores> atoresFilme1 = new ArrayList<>();
        atoresFilme1.add(ator1);
        atoresFilme1.add(ator2);

        List<Atores> atoresFilme2 = new ArrayList<>();
        atoresFilme2.add(ator3);
        atoresFilme2.add(ator4);

        Filme filme1 = new Filme("A Origem", parseDate("2010-08-06"), 160000000,
                "Dom Cobb é um ladrão com a rara habilidade de roubar segredos do inconsciente, obtidos durante o estado de sono. Impedido de retornar para sua família, ele recebe a oportunidade de se redimir ao realizar uma tarefa aparentemente impossível: plantar uma ideia na mente do herdeiro de um império. Para realizar o crime perfeito, ele conta com a ajuda do parceiro Arthur, o discreto Eames e a arquiteta de sonhos Ariadne. Juntos, eles correm para que o inimigo não antecipe seus passos.",
                diretor1, atoresFilme1);
        Filme filme2 = new Filme("Avatar", parseDate("2009-12-18"), 237000000,
                "No exuberante mundo alienígena de Pandora vivem os Na'vi, seres que parecem ser primitivos, mas são altamente evoluídos. Como o ambiente do planeta é tóxico, foram criados os avatares, corpos biológicos controlados pela mente humana que se movimentam livremente em Pandora. Jake Sully, um ex-fuzileiro naval paralítico, volta a andar através de um avatar e se apaixona por uma Na'vi. Esta paixão leva Jake a lutar pela sobrevivência de Pandora",
                diretor2, atoresFilme2);

        filmes.add(filme1);
        filmes.add(filme2);

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

