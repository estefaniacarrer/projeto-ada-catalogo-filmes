package org.filmes.ui;

import org.filmes.model.Atores;
import org.filmes.util.ConsoleUIHelper;
import org.filmes.util.FilmesCadastrados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.filmes.util.ConsoleUIHelper.drawWithRightPadding;

public class AtorListUI extends BasicUI {

    protected final int PAGE_SIZE = 8;
    protected int curPage;
    private List<Atores> atores;
    private int totalPages;


    public AtorListUI() {
        super(DEFAULT_COLUMNS, DEFAULT_ROWS, "Lista de Atores");
        this.atores = FilmesCadastrados.listagemDeAtores();
        this.curPage = 1;
        this.totalPages = (int) Math.ceil((double) atores.size() / PAGE_SIZE);
    }

    @Override
    public int drawContent() {

        int count = 0;
        int startIndex = (curPage - 1) * PAGE_SIZE;
        int endIndex = Math.min(startIndex + PAGE_SIZE, atores.size());

        for (int i = startIndex; i < endIndex; i++) {
            Atores ator = atores.get(i);
            String formattedAtor = String.format("%d -> %s", i, ator.toString());
            drawWithRightPadding(formattedAtor, colunas, ' ');
            count++;
        }
        return count;
    }


    @Override
    public int menuLines() {
        return 6;
    }

    @Override
    public boolean drawMenu() {
        int option = ConsoleUIHelper.askChooseOption(
                "Escolha uma opção",
                "Página Seguinte",
                "Página Anterior",
                "Cadastrar Novo Ator",
                "Voltar para Página Principal");
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
                cadastrarNovoAtor();
                break;
            }
            case 3: {
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

    private boolean cadastrarNovoAtor() {
        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome do ator:");
        String dataNascimentoStr = ConsoleUIHelper.askSimpleInput("Digite a data de nascimento do ator (formato: yyyy-MM-dd):");

        Date dataNascimento = parseDate(dataNascimentoStr);

        Atores novoAtor = new Atores(nome, dataNascimento);
        atores.add(novoAtor);

        ConsoleUIHelper.showMessageAndWait("Ator cadastrado com sucesso!", 2);
        totalPages = (int) Math.ceil((double) atores.size() / PAGE_SIZE);

        return true;
    }


    private Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
