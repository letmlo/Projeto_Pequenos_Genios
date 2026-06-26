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
    private int dificuldade;
    private static final int RODADAS_POR_BATALHA = 5;

    // Estatísticas acumuladas
    private int totalAcertos;
    private int totalErros;

    public BattleManager(Player player, QuestionBank banco) {
        this.player = player;
        this.banco = banco;
        this.dificuldade = 1;
        this.totalAcertos = 0;
        this.totalErros = 0;
    }

    public void setOponente(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public boolean executarBatalha() {
        ConsoleUI.exibirSeparador();
        System.out.println("\nBATALHA: " + player.getNome() + " vs " + enemy.getNome());
        System.out.println(enemy.getPersonagem().getDescricao());
        System.out.println("Dificuldade das perguntas: " + "★".repeat(dificuldade) + "☆".repeat(3 - dificuldade));

        List<Question> perguntas = banco.getPerguntasPorDificuldade(dificuldade);
        int rodadaNestaBatalha = 0;
        int indice = 0;

        while (player.getPersonagem().estaVivo()
                && enemy.getPersonagem().estaVivo()
                && rodadaNestaBatalha < RODADAS_POR_BATALHA
                && indice < perguntas.size()) {

            rodadaNestaBatalha++;
            System.out.println("\n--- Rodada " + rodadaNestaBatalha + "/" + RODADAS_POR_BATALHA + " ---");

            Round round = new Round(perguntas.get(indice), player, enemy);
            round.executar();

            // Acumula estatísticas do round
            totalAcertos += round.getAcertos();
            totalErros += round.getErros();

            indice++;
        }

        ConsoleUI.exibirSeparador();
        if (!enemy.getPersonagem().estaVivo()) {
            System.out.println("✔ Você derrotou " + enemy.getNome() + "!");
            return true;
        } else if (!player.getPersonagem().estaVivo()) {
            System.out.println("✘ Você foi derrotado por " + enemy.getNome() + "...");
            return false;
        } else {
            boolean playerVenceu = player.getPersonagem().getVidaAtual() > enemy.getPersonagem().getVidaAtual();
            if (playerVenceu) {
                System.out.println("⏱ Tempo esgotado! Você venceu por ter mais vida!");
            } else {
                System.out.println("⏱ Tempo esgotado! O oponente tinha mais vida...");
            }
            return playerVenceu;
        }
    }

    public int getTotalAcertos() { return totalAcertos; }
    public int getTotalErros()   { return totalErros; }
}
