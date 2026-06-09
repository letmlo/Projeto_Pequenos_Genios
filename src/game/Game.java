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
        System.out.println("\nBem-vindo ao Pequenos Gênios!");

        configurarJogador();
        iniciarSequencia();
    }

    private void configurarJogador() {
        String nome = ConsoleUI.lerTexto("\nDigite seu nome: ");

        System.out.println("\nEscolha seu personagem:");
        System.out.println("1) Estudante Equilibrado (HP: 100 | ATK: 15 | DEF: 5)");
        System.out.println("   " + new EstudanteEquilibrado("").getDescricao());
        System.out.println("2) Estudante Especialista (HP: 80  | ATK: 25 | DEF: 2)");
        System.out.println("   " + new EstudanteEspecialista("").getDescricao());

        int escolha = ConsoleUI.lerOpcao("Sua escolha (1 ou 2): ", 1, 2);

        Character personagem = escolha == 1
                ? new EstudanteEquilibrado(nome)
                : new EstudanteEspecialista(nome);

        player = new Player(nome, personagem);
        banco = new QuestionBank();

        System.out.println("\nOlá, " + nome + "! Boa sorte na batalha!");
    }

    private void iniciarSequencia() {
        Enemy[] oponentes = {
                new Enemy("Aluno Curioso",  new EstudanteEquilibrado("Aluno Curioso")),
                new Enemy("Nerd da turma",  new EstudanteEspecialista("Nerd da turma")),
                new Enemy("Aluno nota 10",  new EstudanteEspecialista("Aluno nota 10"))
        };

        BattleManager batalha = new BattleManager(player, banco);

        int vitorias = 0;

        for (Enemy oponente : oponentes) {
            if (vitorias > 0) {
                player.getPersonagem().recuperarVida(20);
                System.out.println("\nVocê recuperou 20 de vida antes da próxima batalha!");
            }

            batalha.setOponente(oponente);
            boolean venceu = batalha.executarBatalha();

            if (!venceu) {
                exibirDerrota();
                return;
            }
            vitorias++;
        }

        exibirVitoria();
    }

    private void exibirVitoria() {
        ConsoleUI.exibirSeparador();
        System.out.println("\nPARABÉNS! VOCÊ É O PEQUENO GÊNIO!");
        System.out.println("Pontuação final: " + player.getPontuacao() + " pontos");
        System.out.println("Obrigado por jogar Pequenos Gênios!");
    }

    private void exibirDerrota() {
        ConsoleUI.exibirSeparador();
        System.out.println("\nFim de jogo! Estude mais e tente novamente!");
        System.out.println("Pontuação final: " + player.getPontuacao() + " pontos");
    }
}