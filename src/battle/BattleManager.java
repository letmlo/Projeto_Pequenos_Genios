package battle;

import character.Player;
import character.Enemy;
import question.Question;
import question.QuestionBank;
import ui.ConsoleUI;

import java.util.List;

public class BattleManager {
    private Player player;
    private Enemy enemy;
    private QuestionBank banco;
    private int rodadaAtual;
    private static final int RODADAS_POR_BATALHA = 5;

    public BattleManager(Player player, Enemy enemy, QuestionBank banco) {
        this.player = player;
        this.enemy = enemy;
        this.banco = banco;
        this.rodadaAtual = 0;
    }

    public boolean executarBatalha() {
        System.out.println("\nBATALHA: " + player.getNome() + " vs " + enemy.getNome());
        System.out.println(enemy.getPersonagem().getDescricao());

        List<Question> perguntas = banco.getTodasPerguntas();
        int indice = 0;

        while (player.getPersonagem().estaVivo()
                && enemy.getPersonagem().estaVivo()
                && rodadaAtual < RODADAS_POR_BATALHA
                && indice < perguntas.size()) {

            rodadaAtual++;
            System.out.println("\n--- Rodada " + rodadaAtual + "/" + RODADAS_POR_BATALHA + " ---");

            Round round = new Round(perguntas.get(indice), player, enemy);
            round.executar();
            indice++;
        }

        ConsoleUI.exibirSeparador();
        if (!enemy.getPersonagem().estaVivo()) {
            System.out.println("Você derrotou " + enemy.getNome() + "!");
            return true;
        } else if (!player.getPersonagem().estaVivo()) {
            System.out.println("Você foi derrotado por " + enemy.getNome() + "...");
            return false;
        } else {

            boolean playerVenceu = player.getPersonagem().getVidaAtual() > enemy.getPersonagem().getVidaAtual();
            if (playerVenceu) {
                System.out.println("Tempo esgotado! Você venceu por ter mais vida!");
            } else {
                System.out.println("Tempo esgotado! O oponente tinha mais vida...");
            }
            return playerVenceu;
        }
    }
}
