package org.filmes;

import org.filmes.model.Filme;
import org.filmes.ui.PagedList;

import java.util.ArrayList;
import java.util.List;

public class Catalogo  implements PagedList {

    private List<Filme> filmes;

    public Catalogo() {
        filmes = new ArrayList<>();
    }

    public void adicionarListaDeFilmes(List<Filme> novosFilmes) {
        filmes.addAll(novosFilmes);
    }

    @Override
    public void cadastrarNovoFilme(Filme novoFilme) {
        filmes.add(novoFilme);
    }
    @Override
    public List<Filme> listarFilmes(int pagina, int tamanhoPagina) {
        List<Filme> listagem = new ArrayList<>();
        int primeiroRegistro = tamanhoPagina * (pagina - 1);
        if (primeiroRegistro >= filmes.size()) {
            return listagem;
        }
        int ultimoRegistro = Math.min(primeiroRegistro + tamanhoPagina, filmes.size());
        for (int i = primeiroRegistro; i < ultimoRegistro; i++) {
            Filme filme = filmes.get(i);
            listagem.add(filme);
        }
        return listagem;
    }

    @Override
    public int totalFilmes() {
        return filmes.size();
    }
}





