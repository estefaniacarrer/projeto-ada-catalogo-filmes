package org.filmes;

import org.filmes.model.Filme;
import org.filmes.ui.BasicUI;
import org.filmes.ui.PagedListUI;
import org.filmes.util.FilmesCadastrados;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        List<Filme> filmesDeExemplo = FilmesCadastrados.listagemDeFilmes();
        catalogo.adicionarListaDeFilmes(filmesDeExemplo);


        BasicUI ui = new PagedListUI("Catalogo de filmes", catalogo);
        ui.show();
    }
}