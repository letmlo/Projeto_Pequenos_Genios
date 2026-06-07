package battle;

import character.Player;
import character.Enemy;
import question.Question;
import ui.ConsoleUI;

public class Round {
    private Question pergunta;
    private Player player;
    private Enemy enemy;
    private AnswerEvaluator avaliador;

    public Round(Question pergunta, Player player, Enemy enemy) {
        this.pergunta = pergunta;
        this.player = player;
        this.enemy = enemy;
        this.avaliador = new AnswerEvaluator();
    }

    public void executar() {
        ConsoleUI.exibirSeparador();
        System.out.println("\nNOVA RODADA");
        ConsoleUI.exibirStatus(player, enemy);

        pergunta.exibir();
        String resposta = ConsoleUI.lerResposta();

        boolean acertou = avaliador.avaliar(pergunta, resposta);

        if (acertou) {
            int dano = avaliador.calcularDano(
                    player.getPersonagem().getAtaque(),
                    pergunta.getDificuldade()
            );
            int pontos = avaliador.calcularPontos(pergunta.getDificuldade());

            enemy.getPersonagem().receberDano(dano);
            player.adicionarPontos(pontos);

            System.out.println("\n Resposta correta! Você causou " + dano + " de dano e ganhou " + pontos + " pontos!");
        } else {
            int penalidade = avaliador.calcularPenalidade(pergunta.getDificuldade());
            player.getPersonagem().receberDano(penalidade);
            System.out.println("\nx Resposta errada! Você perdeu " + penalidade + " de vida.");
        }
    }
}

