package org.filmes.ui;

import org.filmes.model.Filme;
import org.filmes.util.ConsoleUIHelper;

import java.util.ArrayList;
import java.util.List;

import static org.filmes.util.ConsoleUIHelper.drawWithRightPadding;

public class PagedListUI extends BasicUI {
    protected final int PAGE_SIZE;
    protected int curPage;
    protected PagedList pageSource;
    private List<Filme> dataList;
    private int totalPages;


    public PagedListUI(String titulo, PagedList pageSource) {
        this(DEFAULT_COLUMNS, DEFAULT_ROWS, titulo, pageSource);
        this.totalPages = (int) Math.ceil((double) pageSource.totalFilmes() / PAGE_SIZE);
    }

    public PagedListUI(int colunas, int linhas, String titulo, PagedList pageSource) {
        super(colunas, linhas, titulo);
        PAGE_SIZE = 2;
        curPage = 1;
        this.pageSource = pageSource;
    }

    @Override
    public int drawContent() {
        dataList = pageSource.listarFilmes(curPage, PAGE_SIZE);
        totalPages = (int) Math.ceil((double) pageSource.totalFilmes() / PAGE_SIZE);

        int count = 0;
        for (int i = 0; i < dataList.size(); i++) {
            Filme filme = dataList.get(i);
            String formattedFilm = String.format("%d -> %s", i, filme.toString());
            drawWithRightPadding(formattedFilm, colunas, ' ');
            count++;
        }
        return count;
    }

    @Override
    public int menuLines() {
        return 9;
    }

    @Override
    public boolean drawMenu() {
        int option = ConsoleUIHelper.askChooseOption(
                "Escolha uma opção",
                "Página Seguinte",
                "Página Anterior",
                "Cadastrar Filme",
                "Cadastrar Ator",
                "Cadastrar Diretor",
                "Associar Ator/Diretor a Filme",
                "Pesquisar Filme",
                "Sair");
        switch (option) {
            case 0: {
                nextPage();
                break;
            }
            case 1: {
                previousPage();
                break;
            }
            case 2: {
                cadastrarFilme();
                break;
            }
            case 3: {
                cadastrarAtor();
                break;
            }
            case 4: {
                cadastrarDiretor();
                break;
            }
            case 5: {
                associarAtorDiretor();
                break;
            }
            case 6: {
                pesquisarFilme();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    private void nextPage() {
        if (curPage < totalPages) {
            curPage++;
        }
    }

    private void previousPage() {
        if (curPage > 1) {
            curPage--;
        }
    }

    private void cadastrarFilme() {
    }

    private void cadastrarAtor() {
    }

    private void cadastrarDiretor() {
    }

    private void associarAtorDiretor() {
    }

    private void pesquisarFilme() {
        String searchTerm = ConsoleUIHelper.askSimpleInput("Digite o nome do filme para pesquisa:");
        searchTerm = searchTerm.toLowerCase();

        List<Filme> resultados = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            dataList = pageSource.listarFilmes(i, PAGE_SIZE);
            for (Filme filme : dataList) {
                if (filme.getNome().toLowerCase().contains(searchTerm)) {
                    resultados.add(filme);
                }
            }
        }

        if (resultados.isEmpty()) {
            ConsoleUIHelper.showMessageAndWait("Nenhum filme encontrado com o nome informado.", 2);
        } else {
            ConsoleUIHelper.clearScreen();
            ConsoleUIHelper.drawHeader("Filmes Encontrados:", colunas);
            for (Filme filme : resultados) {
                drawWithRightPadding(filme.toString(), colunas, ' ');
            }
            ConsoleUIHelper.waitForEnter("Pressione Enter para retornar ao menu principal...");
        }
    }
}



