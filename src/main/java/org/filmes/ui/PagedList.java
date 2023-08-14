package org.filmes.ui;

import org.filmes.model.Filme;

import java.util.List;

public interface PagedList {
    List<Filme> listarFilmes(int pagina, int tamanhoPagina);
    int totalFilmes();
}



