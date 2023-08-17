package org.filmes.ui;

import org.filmes.model.Diretores;
import org.filmes.util.ConsoleUIHelper;
import org.filmes.util.FilmesCadastrados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.filmes.util.ConsoleUIHelper.drawWithRightPadding;

public class DiretorListUI extends BasicUI {

    protected final int PAGE_SIZE = 8;
    protected int curPage;
    private List<Diretores> diretores;
    private int totalPages;

    public DiretorListUI() {
        super(DEFAULT_COLUMNS, DEFAULT_ROWS, "Lista de Atores");
        this.diretores = FilmesCadastrados.listagemDeDiretores();
        this.curPage = 1;
        this.totalPages = (int) Math.ceil((double)diretores.size() / PAGE_SIZE);
    }

    @Override
    public int drawContent() {

        int count = 0;
        int startIndex = (curPage - 1) * PAGE_SIZE;
        int endIndex = Math.min(startIndex + PAGE_SIZE, diretores.size());

        for (int i = startIndex; i < endIndex; i++) {
            Diretores diretor = diretores.get(i);
            String formattedAtor = String.format("%d -> %s", i, diretor.toString());
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
                "Cadastrar Novo Diretor",
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
                cadastrarNovoDiretor();
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

    private boolean cadastrarNovoDiretor() {
        String nome = ConsoleUIHelper.askSimpleInput("Digite o nome do diretor:");
        String dataNascimentoStr = ConsoleUIHelper.askSimpleInput("Digite a data de nascimento do ator (formato: yyyy-MM-dd):");

        Date dataNascimento = parseDate(dataNascimentoStr);
        Diretores novoDiretor = new Diretores(nome, dataNascimento);
        diretores.add(novoDiretor);

        ConsoleUIHelper.showMessageAndWait("Ator cadastrado com sucesso!", 2);
        totalPages = (int) Math.ceil((double) diretores.size() / PAGE_SIZE);

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
