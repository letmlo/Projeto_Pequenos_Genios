package game;

import battle.BattleManager;
import character.*;
import question.QuestionBank;
import ui.ConsoleUI;
import character.Character;
import character.EstudanteEquilibrado;
import character.EstudanteEspecialista;

public class Game {
    private Player player;
    private QuestionBank banco;

    public void iniciar() {
        ConsoleUI.exibirTitulo();
        configurarJogador();
        iniciarSequencia();
    }

    private void configurarJogador() {
        String nome = ConsoleUI.lerTexto("\nDigite seu nome: ");

        System.out.println("\nEscolha seu personagem:");
        System.out.println("1) Estudante Equilibrado (HP: 100 | ATK: 15 | DEF: 5)");
        System.out.println("   " + new EstudanteEquilibrado("").getDescricao());
        System.out.println("   Super: Cola Mental — " + new EstudanteEquilibrado("").getDescricaoSuper());
        System.out.println();
        System.out.println("2) Estudante Especialista (HP: 80  | ATK: 25 | DEF: 2)");
        System.out.println("   " + new EstudanteEspecialista("").getDescricao());
        System.out.println("   Super: Domínio Absoluto — " + new EstudanteEspecialista("").getDescricaoSuper());

        int escolha = ConsoleUI.lerOpcao("\nSua escolha (1 ou 2): ", 1, 2);

        Character personagem = escolha == 1
                ? new EstudanteEquilibrado(nome)
                : new EstudanteEspecialista(nome);

        player = new Player(nome, personagem);
        banco = new QuestionBank();

        System.out.println("\nOlá, " + nome + "! Boa sorte na batalha!");
    }

    private void iniciarSequencia() {
        Enemy[] oponentes = {
                new Enemy("Aluno Kumon",    new EstudanteEquilibrado("Aluno Kumon")    {{ vidaMaxima = 80; vidaAtual = 80; defesa = 3; }}),
                new Enemy("Calouro do IME", new EstudanteEspecialista("Calouro do IME") {{ vidaMaxima = 60; vidaAtual = 60; defesa = 1; }}),
                new Enemy("Luciano Huck",  new Boss("Luciano Huck", 200, 35, 5))
        };

        int[] dificuldades = {1, 2, 3};

        BattleManager batalha = new BattleManager(player, banco);
        int vitorias = 0;

        for (int i = 0; i < oponentes.length; i++) {
            if (vitorias > 0) {
                player.getPersonagem().recuperarVida(20);
                System.out.println("\n Você recuperou 20 de vida antes da próxima batalha!");
            }

            batalha.setOponente(oponentes[i]);
            batalha.setDificuldade(dificuldades[i]);

            boolean venceu = batalha.executarBatalha();

            if (!venceu) {
                exibirDerrota(batalha, vitorias);
                return;
            }
            vitorias++;
        }

        exibirVitoria(batalha, vitorias);
    }

    private void exibirVitoria(BattleManager batalha, int vitorias) {
        ConsoleUI.exibirSeparador();
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   PARABÉNS! VOCÊ É O PEQUENO GÊNIO!  ║");
        System.out.println("╚══════════════════════════════════════╝");
        exibirEstatisticas(batalha, vitorias);
    }

    private void exibirDerrota(BattleManager batalha, int vitorias) {
        ConsoleUI.exibirSeparador();
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         FIM DE JOGO!                 ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Estude mais e tente novamente!");
        exibirEstatisticas(batalha, vitorias);
    }

    private void exibirEstatisticas(BattleManager batalha, int vitorias) {
        int acertos = batalha.getTotalAcertos();
        int erros   = batalha.getTotalErros();
        int total   = acertos + erros;
        int taxa    = total > 0 ? (acertos * 100 / total) : 0;

        System.out.println("\n──────── ESTATÍSTICAS FINAIS ────────");
        System.out.printf("  Batalhas vencidas : %d / 3%n", vitorias);
        System.out.printf("  Respostas certas  : %d%n", acertos);
        System.out.printf("  Respostas erradas : %d%n", erros);
        System.out.printf("  Taxa de acerto    : %d%%%n", taxa);
        System.out.printf("  Pontuação final   : %d pontos%n", player.getPontuacao());
        System.out.println("─────────────────────────────────────");
        System.out.println("\nObrigado por jogar Pequenos Gênios!");
    }
}
